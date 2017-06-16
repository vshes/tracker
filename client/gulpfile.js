var gulp = require('gulp'),
    clean = require('gulp-clean'),
    inject = require('gulp-inject'),
    bowerFiles =require('main-bower-files'),
    browserSync =require('browser-sync').create(),
    sortFiles = require('gulp-angular-filesort'),
    filter = require('gulp-filter'),
    concat = require('gulp-concat'),
    merge = require('merge-stream'),
    cleanCss = require('gulp-clean-css'),
    uglify = require('gulp-uglify');

var config ={
    paths:{
        src: "./src",
        build:'./build',
        bower:'./bower_components'
    }
};

gulp.task('clean',function () {

    return gulp.src(config.paths.build,{read:false})
        .pipe(clean());
});

gulp.task('inject',function () {
    var cssFiles = gulp.src(
        [config.paths.src + '/**/*.css'],
        {read: false});

    var jsFiles = gulp.src([config.paths.src + '/**/*.js'],
        {read:true});

      return  gulp.src(config.paths.src + '/index.html')
        .pipe(inject(gulp.src(bowerFiles(),{read:true}),{name: 'bower'}))
        .pipe(inject(cssFiles,{ignorePath :'/src', addRootSlash:false}))
        .pipe(inject(jsFiles.pipe(sortFiles()),{ignorePath: '/src',addRootSlash:false}))
        .pipe(gulp.dest(config.paths.src));
});

gulp.task('serve',['inject'],function () {
   browserSync.init({
        server:{
            baseDir:[config.paths.src,config.paths.build,config.paths.bower],
            routes:{
                '/bower_components': 'bower_components'
            }
        },
       files:[
           config.paths.src + '/**'
       ]
   });
});

gulp.task('minifyCss',function () {
    var vendorStyles = gulp.src(bowerFiles())
        .pipe(filter(['**/*.css']))
        .pipe(concat('vendor.min.css'))
        .pipe(cleanCss({debug:true,compatibility:'ie8'}))
        .pipe(gulp.dest(config.paths.build +'/styles'));

    var appStyles = gulp.src(config.paths.src +'/**/*.css')
        .pipe(concat('app.min.css'))
        .pipe(cleanCss({debug:true,comaptibility:'ie8'}))
        .pipe(gulp.dest(config.paths.build + '/styles'));

    return merge(vendorStyles,appStyles);
    
});

gulp.task('minifyJs',function () {
    var vendorScripts =gulp.src(bowerFiles())
        .pipe(filter(['**/*.js']))
        .pipe(sortFiles())
        .pipe(concat('vendor.min.js'))
        .pipe(uglify())
        .pipe(gulp.dest(config.paths.build +'/scripts'));

    var appScripts = gulp.src(config.paths.src + '/**/*.js')
        .pipe(sortFiles())
        .pipe(concat('app.min.js'))
        .pipe(uglify())
        .pipe(gulp.dest(config.paths.build +'/scripts'));


    return merge(appScripts,vendorScripts);

});

gulp.task('html',function () {
  return  gulp.src([config.paths.src +'/**/*.html' ,'!' +config.paths.src + '/index.html'])
       .pipe(gulp.dest(config.paths.build));

});

gulp.task('fonts',function () {
   return  gulp.src(bowerFiles())
        .pipe(filter(['**/*.{svg,ttf,eot,woff,woff2}']))
        .pipe(gulp.dest(config.paths.build +'/fonts'));
});

gulp.task( 'other',function () {
   return  gulp.src([config.paths.src + '/**/*.*' ,'!/**/*.js', '!/**/*.css', '!/**/*.html'])
       .pipe(gulp.dest(config.paths.build));
});

gulp.task('build',['clean','minifyCss','minifyJs','html','fonts','other'],function () {
    var vendorFiles = gulp.src([
        config.paths.build + '/styles/vendor.min.css',
        config.paths.build +'/scripts/vendor.min.js'],{read:false});

    var appfiles = gulp.src([
        config.paths.build + '/styles/app.min.css',
        config.paths.build + '/scripts/app.min.js'
    ],{read:false});

    return  gulp.src(config.paths.src + '/index.html')
        .pipe(inject(vendorFiles,{name:'vendor', ignorePath :'/build', addRootSlash:false}))
        .pipe(inject(appfiles,{name:'app',ignorePath:'/build',addRootSlash:false}))
        .pipe(gulp.dest(config.paths.build));
})
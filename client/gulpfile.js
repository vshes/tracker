var gulp = require('gulp'),
    clean = require('gulp-clean'),
    inject = require('gulp-inject'),
    bowerFiles =require('main-bower-files'),
    browserSync =require('browser-sync').create(),
    sortFiles = require('gulp-angular-filesort');

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
        .pipe(inject(gulp.src(bowerFiles(),{read:false}),{name: 'bower'},{addRootSlash:false}))
        .pipe(inject(cssFiles,{ignorePath :'/src', addRootSlash:false}))
        .pipe(inject(jsFiles.pipe(sortFiles()),{ignorePath: '/src',addRootSlash:false}))
        .pipe(gulp.dest(config.paths.src));
});

gulp.task('serve',['inject'],function () {
   browserSync.init({
        server:{
            baseDir:[config.paths.src,config.paths.build,config.paths.bower],
            routes:{
                '/bower_components' : 'bower_components'
            }
        },
       files:[
           config.paths.src + '/**'
       ]
   });
});


'use strict';

var glob = require("glob")
const Path = require('path');

const basePath = './src/plugins';

let plugins = [];
glob.sync(basePath + "/*.js").forEach(function (file) {
    const moduleName =  Path.parse(file).name
             if (moduleName !== "index") {
                 const mod = require('./' + moduleName)
                 plugins = plugins.concat(mod)
              }
    return plugins;
});


module.exports = plugins;

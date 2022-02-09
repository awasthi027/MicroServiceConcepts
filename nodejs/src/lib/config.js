'use strict';

const nconf = require('nconf');
const fs = require("fs");

let filePath = './src/config/application.json'
 /*
  // Setup nconf to use (in-order):
  //   1. Command-line arguments
  //   2. Environment variables
  //   3. A file located at 'path/to/config.json'
  */

  nconf.argv()
   .env()
   .file({ file: filePath });

   /*
   read custom file
   if (fs.existsSync(filePath)) {
       console.log("application.json exists");
       nconf.file('custom', filePath);
   }else{
       console.log("customConfig.json doesn't exist");
   }
*/

  //
  // Set a few variables on `nconf`.
  //
//  nconf.set('database:host', '127.0.0.1');
//  nconf.set('database:port', 5984);

//   fs.readFile(filePath, "utf8", (err, jsonString) => {
//     if (err) {
//       console.log("File read failed:", err);
//       return;
//     }
//     console.log("File data:", jsonString);
//   });

 module.exports = nconf;
const Jwt = require('@hapi/jwt');

const shared_secret_key =  'some_shared_secret'
// Generate a Token
//const createToken = function createUser(userid) {
// console.log(`Call create method ${userid}`)
//

//   return token
//}
//
//module.exports = [
//   createToken,
//];

exports.createToken = (username) => {
  let token  =  Jwt.token.generate(
     {
        aud: 'urn:audience:test',
        iss: 'urn:issuer:test',
        user: username,
        group: 'hapi_community',
        scope:['admin'],
    },
    {
        key: shared_secret_key,
        algorithm: 'HS512'
    },
    {
        ttlSec: 14400 // 4 hours
    }
   );
   return token
}
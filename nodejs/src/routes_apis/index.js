var cart = require('./cart_route');
var user = require('./user_route');
var todo = require('./todo_route');

module.exports = [].concat(cart, user,todo);
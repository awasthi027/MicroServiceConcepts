module.exports = [
  {
    path: '/cart1',
    method: 'GET',
    handler: function (request, reply) {
      return { message : 'return first cart'};
    }
  },
  {
    path: '/cart2',
    method: 'GET',
    handler: function (request, reply) {
      return { message : 'return second cart'};
    }
  }
]
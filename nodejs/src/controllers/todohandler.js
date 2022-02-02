

//const getToDo = (req, h) => {
//   var todo = { title: 'Java Topic', desc: 'This java topic we have to read in coming time'}
//   return todo;
//}
//
//module.exports = [
//  getToDo
//];

exports.get = (req,h) => {
  var todo = { title: 'Java Topic', desc: 'This java topic we have to read in coming time'}
   return todo;

};
exports.createTODO = (req,h) => {
  var todo = { status: 'Topic Created', 'topic': { title: req.payload.title, desc: req.payload.desc}}
   return todo;

};
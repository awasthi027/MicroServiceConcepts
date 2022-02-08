
var User = require('../models/user');
var auth = require('../auth/JWT')

function verifyUniqueUser(req, h) {
  return User.findOne({username: req.payload.username }).exec().then((user) => {
            if (user.username == req.payload.username) {
                return { message:'We already have this user name in our database. Please try with another user name'};
               }
               h.continue
      	  }).catch((err) => {
      		return { err: err};
      	  });

}

exports.createUser = (req, h) => {
  const userData = {
    username: req.payload.username,
    password: req.payload.password,
    age: req.payload.age,
    city: req.payload.city
  };
    let reqUserName = req.payload.username;
     verifyUniqueUser(req, h)

     return User.create(userData).then((user) => {
                         return { message: "User created successfully", user: user };
                      }).catch((err) => {
                        return { err: err };
                      });


}

exports.signInUser = (req, h) => {

   let reqUsername = req.payload.username
   let password = req.payload.password

   return User.findOne({username: reqUsername }).exec().then((user) => {
  		if (!user) return { message:'We have not find this user in our database.Please try with correct user.'};
  		if (user.password === password) {
  	     let userToken = auth.createToken(user.username)
  	     return { message: 'Login successful', accessToken: userToken}
  		 } else {
  		  return { message:'User password is in correct.'};
  		}
  		return {user: user};
  	  }).catch((err) => {
  		return { err: err};
  	  });
}

exports.users = (req,h) => {

	return User.find({}).exec().then((user) => {
		return {users: user};
	}).catch((err) => {
        return {err: err};
	});
};

exports.userProfile = (req,h) => {
       let reqUsername = req.params.username
    return User.findOne({username: reqUsername }).exec().then((user) => {
     	     return { message:'Success', data: user};
     	  }).catch((err) => {
     		return { err: err};
     	  });
};

exports.deleteUser = (req,h) => {
       let reqUsername = req.params.username
    return User.findOneAndDelete({username: reqUsername }).exec().then((user) => {
     	     return { message:'User has been deleted.'};
     	  }).catch((err) => {
     		return { err: err};
     	  });
};
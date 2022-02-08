'use strict';


const mongoose = require('mongoose');

const Schema = mongoose.Schema;

const userModel = new Schema({ username: { type: String, required: true, index: {unique: true}},
	password:{ type: String, required: true},
	age:{ type: Number, required: true},
	city: {type: String, required: true} });

module.exports = mongoose.model('User', userModel, 'users');


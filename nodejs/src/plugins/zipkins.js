
const {Tracer, ExplicitContext, ConsoleRecorder} = require('zipkin');
const zipkinMiddleware = require('zipkin-instrumentation-hapi').hapiMiddleware;

const ctxImpl = new ExplicitContext();
const recorder = new ConsoleRecorder();

const localServiceName = 'Node-JS-API-Gateway'; // name of this application
const tracer = new Tracer({ctxImpl, recorder, localServiceName});
 module.exports = [
   {
    plugin: zipkinMiddleware,
    options: {tracer}
   }
 ];



var ScriptEngine = Java.type('javax.script.ScriptEngine');
var ScriptEngineManager = Java.type('javax.script.ScriptEngineManager');
var engine = new ScriptEngineManager().getEngineByName("nashorn");
print(engine.getFactory().engineName);

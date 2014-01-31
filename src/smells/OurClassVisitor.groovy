package smells


import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.ConstructorNode
import org.codehaus.groovy.ast.FieldNode
import org.codehaus.groovy.ast.GroovyClassVisitor
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.ast.PropertyNode
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.syntax.SyntaxException

class OurClassVisitor implements GroovyClassVisitor { 

	SourceUnit sourceUnit
	OurClassVisitor(theSourceUnit) { sourceUnit = theSourceUnit } 
	
	private void reportError(message, lineNumber, columnNumber) {
	    sourceUnit.addError(new SyntaxException(message, lineNumber, columnNumber)) 
	}
	void visitMethod(MethodNode node) {
	    if(node.name.size() == 1)
	    reportError "Ponele onda y decime que hace el metodo", node.lineNumber, node.columnNumber
	    node.parameters.each { 
			parameter -> if(parameter.name.size() == 1)
	        	reportError "que valor tiene este parametro?", parameter.lineNumber, parameter.columnNumber
	    } 
	}
	
	@Override
	void visitClass(ClassNode node) {
		
	}
	void visitConstructor(ConstructorNode node) {
		
	}
	void visitField(FieldNode node) {
		
	}
	void visitProperty(PropertyNode node) {
		if(node.name.size() == 1){
			reportError "No seas guaso...", node.lineNumber, node.columnNumber
		}
	}
	

}
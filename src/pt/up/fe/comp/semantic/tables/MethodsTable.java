package pt.up.fe.comp.semantic.tables;

import pt.up.fe.comp.jmm.analysis.table.Symbol;
import pt.up.fe.comp.jmm.analysis.table.Type;
import pt.up.fe.comp.jmm.parser.JmmParserResult;
import pt.up.fe.comp.semantic.JmmMethodSignature;
import pt.up.fe.comp.semantic.visitors.MethodDeclarationVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodsTable {
    private final Map<String, JmmMethodSignature> methodSignatures;
    private final Map<String, List<Symbol>> localVariables;

    public MethodsTable(JmmParserResult parserResult) {
        this.methodSignatures = new HashMap<>();
        this.localVariables = new HashMap<>(); // WIP

        MethodDeclarationVisitor mdv = new MethodDeclarationVisitor();
        mdv.visit(parserResult.getRootNode(), this.methodSignatures);
    }

    public Map<String, JmmMethodSignature> getMethodSignatures() {
        return methodSignatures;
    }

    public Map<String, List<Symbol>> getLocalVariables() {
        return localVariables;
    }

    public Type getReturnType(String methodSignature) {
        if (methodSignatures.containsKey(methodSignature)) {
            return methodSignatures.get(methodSignature).getReturnType();
        }

        return new Type("NULL", false);
    }

    public List<Symbol> getParameters(String methodSignature) {
        if (methodSignatures.containsKey(methodSignature)) {
            return methodSignatures.get(methodSignature).getParameters();
        }

        return new ArrayList<>();
    }
}

package pt.up.fe.comp.semantic.tables;

import pt.up.fe.comp.jmm.parser.JmmParserResult;
import pt.up.fe.comp.semantic.visitors.symbolTableBuilder.ImportDeclarationVisitor;

import java.util.ArrayList;
import java.util.List;

public class ImportsTable extends ReportCollectorTable {
    private final List<String> imports = new ArrayList<>();

    public ImportsTable(JmmParserResult parserResult) {
        ImportDeclarationVisitor importDeclarationVisitor = new ImportDeclarationVisitor();
        importDeclarationVisitor.visit(parserResult.getRootNode(), this.imports);
        this.reports.addAll(importDeclarationVisitor.getReports());
    }

    public List<String> getImports() {
        return imports;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Imports\n");
        for (var imp : imports) {
            str.append(imp).append("\n");
        }
        str.append("-----\n");
        return str.toString();
    }
}

package app.services.api;

import app.dto.bindings.json.BranchImportJsonDto;
import app.dto.views.xml.BranchesExportXmlDto;

import java.util.List;

public interface BranchService<Branch, Long> extends ServiceInterface<Branch, Long> {
    List<Object[]> topBranches();

    void persist(BranchImportJsonDto branchImportJsonDto);

    BranchesExportXmlDto getTopBranches(List<Object[]> topBranches);
}

package app.services.impl;

import app.dao.BranchDao;
import app.dao.TownDao;
import app.dto.bindings.json.BranchImportJsonDto;
import app.dto.views.xml.BranchExportXmlDto;
import app.dto.views.xml.BranchesExportXmlDto;
import app.entities.Branch;
import app.entities.Town;
import app.services.api.BranchService;
import app.utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BranchServiceImpl implements BranchService<Branch, Long> {

    @Autowired
    private BranchDao branchDao;
    @Autowired
    private TownDao townDao;

    @Override
    public Branch findById(Long id) {
        return branchDao.findOne(id);
    }

    @Override
    public List<Branch> findAll() {
        return branchDao.findAll();
    }

    @Override
    public void save(Branch object) {
        branchDao.save(object);
    }


    private boolean isValidDto(BranchImportJsonDto branchImportJsonDto) {
        return branchImportJsonDto.getName() != null && branchImportJsonDto.getTown() != null;
    }

    @Override
    public List<Object[]> topBranches() {
        return branchDao.topBranches();
    }

    @Override
    public void persist(BranchImportJsonDto branchImportJsonDto) {
        if (isValidDto(branchImportJsonDto)) {
            Branch branch = DTOConverter.convert(branchImportJsonDto, Branch.class);
            Town town = townDao.findByName(branchImportJsonDto.getTown());
            branch.setTown(town);
            this.save(branch);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public BranchesExportXmlDto getTopBranches(List<Object[]> topBranches) {
        List<BranchExportXmlDto> branchDtos = new ArrayList<>();

        for (Object[] currentBranch : topBranches) {
            BranchExportXmlDto branchDto = new BranchExportXmlDto();
            branchDto.setName(currentBranch[0].toString());
            branchDto.setTownName(currentBranch[1].toString());
            branchDto.setTotalClients(Integer.valueOf(currentBranch[2].toString()));
            branchDtos.add(branchDto);
        }

        BranchesExportXmlDto wrapper = new BranchesExportXmlDto();
        wrapper.setBranches(branchDtos);
        return wrapper;
    }
}

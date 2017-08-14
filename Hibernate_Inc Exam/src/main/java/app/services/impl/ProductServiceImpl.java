package app.services.impl;

import app.dao.BranchDao;
import app.dao.ProductDao;
import app.dto.bindings.xml.ProductImportXmlDto;
import app.entities.Branch;
import app.entities.Product;
import app.services.api.ProductService;
import app.utils.DTOConverter;
import app.validations.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService<Product, Long> {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private BranchDao branchDao;

    @Override
    public Product findById(Long id) {
        return productDao.findOne(id);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void save(Product object) {
        productDao.save(object);
    }


    @Override
    public void persist(ProductImportXmlDto productDto) {
        Product product = DTOConverter.convert(productDto, Product.class);
        Branch branch = branchDao.findByName(productDto.getBranchName());
        product.setBranch(branch);
        if (DataValidator.checkIsValid(product)) {
            this.save(product);
        } else {
            throw new IllegalArgumentException();
        }
    }
}

package xyz.codingmentor.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.api.CRUDRepoAnnotation;
import xyz.codingmentor.api.CRUDRepository;
import xyz.codingmentor.api.CRUDService;
import xyz.codingmentor.api.CRUDSpecificationAnnotation;
import xyz.codingmentor.api.EntityModel;
import xyz.codingmentor.model.Category;

/**
 *
 * @author Péter
 */
@Stateless
@CRUDSpecificationAnnotation(EntityModel.CATEGORY)
public class CategoryCRUDService extends GeneralCRUDService<Category> implements CRUDService<Category> {

    public CategoryCRUDService() {
        super(null);
    }

    @Inject
    public CategoryCRUDService(@CRUDRepoAnnotation(EntityModel.CATEGORY) CRUDRepository<Category> repository) {
        super(repository);
    }

}

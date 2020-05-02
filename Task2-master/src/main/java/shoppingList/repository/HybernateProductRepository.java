package shoppingList.repository;

import shoppingList.domain.Product;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Repository
@Transactional
public class HybernateProductRepository implements ProductRepository{
    private final SessionFactory sessionFactory;

    @Autowired
    public HybernateProductRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Product insert (Product product) {
        sessionFactory.getCurrentSession().save(product);
        return product;
    }

    @Override
    public Optional <Product> findProductById (Long id) {
        Product product = (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(product);
    }


    @Override
    public boolean existsByName(String name) {
        String query = "select case when count(*)> 0 " +
                "then true else false end " +
                "from Product t where t.name=:name";
        return (boolean) sessionFactory.getCurrentSession().createQuery(query)
                .setString("name", name)
                .setMaxResults(1)
                .uniqueResult();
    }

   @Override
    public void deleteProductById (Product product) {
        sessionFactory.getCurrentSession().delete(product);
    }

    @Override
    public void change (Product product) {
        sessionFactory.getCurrentSession().update(product);
        sessionFactory.getCurrentSession().save(product);
    }

}

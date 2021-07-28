package product_manage.model.repository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import product_manage.model.bean.Product;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.*;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    @Override
    public List<Product> findAll() {
        TypedQuery<Product> product = BaseRepository.entityManager.createQuery("SELECT p FROM product as p", Product.class);
        return product.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction transaction=BaseRepository.entityManager.getTransaction();
            transaction.begin();
            BaseRepository.entityManager.merge(product);
    }

    @Override
    public Product findById(int id) {
        String query="SELECT p FROM product AS p WHERE p.id = :id";
        TypedQuery<Product> typedQuery= BaseRepository.entityManager.createQuery(query,Product.class);
        typedQuery.setParameter("id",id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void update(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Product origin = findById(product.getId());
            origin.setName(product.getName());
            origin.setPrice(product.getPrice());
            origin.setDescription(product.getDescription());
            origin.setMadeIn(product.getMadeIn());
            session.saveOrUpdate(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(Product product) {
       Session session=BaseRepository.sessionFactory.openSession();
       Transaction transaction=null;
       try{
           transaction=session.beginTransaction();
           session.delete(product);
       }catch (Exception e){
           if (transaction != null) {
               transaction.rollback();
           }
           e.printStackTrace();
       }finally {
           session.flush();
           session.close();
       }
    }

    @Override
    public Product finByName(String name) {
        String query="SELECT p FROM product AS p WHERE p.name like :name";
        TypedQuery<Product> typedQuery= BaseRepository.entityManager.createQuery(query,Product.class);
        typedQuery.setParameter("name","%"+name+"%");
        return typedQuery.getSingleResult();
    }
}

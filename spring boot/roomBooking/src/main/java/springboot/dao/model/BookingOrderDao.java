package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.bean.model.BookingOrder;

@Repository("model.BookingOrderDao")
public interface BookingOrderDao extends JpaRepository<BookingOrder, Integer> {
}

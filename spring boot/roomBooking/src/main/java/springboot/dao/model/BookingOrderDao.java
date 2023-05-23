package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.bean.model.BookingOrder;

public interface BookingOrderDao extends JpaRepository<BookingOrder, Integer> {
}

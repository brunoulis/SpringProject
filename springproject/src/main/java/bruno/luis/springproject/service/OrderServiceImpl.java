package bruno.luis.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bruno.luis.springproject.model.Order;
import bruno.luis.springproject.repository.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService{


    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

}

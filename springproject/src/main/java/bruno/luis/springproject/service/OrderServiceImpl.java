package bruno.luis.springproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bruno.luis.springproject.model.Order;
import bruno.luis.springproject.model.User;
import bruno.luis.springproject.repository.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public String generateNumberOrder() {
        int num = 0;
        String numberConcat = "";

        List<Order> orders = findAll();

        List<Integer> numbers = new ArrayList<Integer>();

        orders.stream().forEach(o -> numbers.add(Integer.parseInt(o.getNumber())));

        if (numbers.isEmpty()) {
            num = 1;
        } else {
            num = numbers.stream().max(Integer::compare).get() + 1;
        }

        if (num < 10) {
            numberConcat = "00000000" + String.valueOf(num);
        } else if (num < 100) {
            numberConcat = "0000000" + String.valueOf(num);
        } else if (num < 1000) {
            numberConcat = "000000" + String.valueOf(num);
        } else if (num < 10000) {
            numberConcat = "00000" + String.valueOf(num);
        } else if (num < 100000) {
            numberConcat = "0000" + String.valueOf(num);
        } else if (num < 1000000) {
            numberConcat = "000" + String.valueOf(num);
        } else if (num < 10000000) {
            numberConcat = "00" + String.valueOf(num);
        } else if (num < 100000000) {
            numberConcat = "0" + String.valueOf(num);
        } else {
            numberConcat = String.valueOf(num);
        }

        return numberConcat;
    }

    @Override
    public List<Order> findByUser(User user) {
        // TODO Auto-generated method stub
        return orderRepository.findByUser(user);
    }

}

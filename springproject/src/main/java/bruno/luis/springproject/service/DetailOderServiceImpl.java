package bruno.luis.springproject.service;

import bruno.luis.springproject.model.DetailOrder;
import bruno.luis.springproject.repository.IDetailOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailOderServiceImpl implements IDetailOrderService{

    @Autowired
    private IDetailOrderRepository detailOrderRepository;

    @Override
    public DetailOrder save(DetailOrder detailOrder) {
        return detailOrderRepository.save(detailOrder);
        
    }

}

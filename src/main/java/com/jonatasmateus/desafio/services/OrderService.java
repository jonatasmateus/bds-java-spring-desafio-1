package com.jonatasmateus.desafio.services;

import com.jonatasmateus.desafio.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order) {
        return order.getBasic() - (order.getBasic() * order.getDiscount() / 100) + shippingService.shipment(order);
        // E.g. 800 - (800 * 10 / 100) + 0 = 720
    }
}

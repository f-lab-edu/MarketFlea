package com.flab.marketflea.service.shopservice.adminservice;

import org.springframework.stereotype.Service;

@Service
public interface ShopAdminService {

    void approve(long id);
    void reject(long id);
    void open(long id);
    void close(long id);

}

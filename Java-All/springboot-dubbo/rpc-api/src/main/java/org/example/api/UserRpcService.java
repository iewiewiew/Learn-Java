package org.example.api;

import org.example.dto.UserDTO;

/**
 * @author weimenghua
 * @time 2023-01-12 14:08
 * @description
 */
public interface UserRpcService {
    UserDTO get(Integer id);
}

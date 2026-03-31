package ecommerce;

import java.util.Optional;

public interface ClienteRepository {

    Optional<Cliente> findById(String id);

}

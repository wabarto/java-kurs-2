package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryAccountRepository implements Repository<BankAccount, String> {

    private final Map<String, BankAccount> storage = new HashMap<>();

    @Override
    public void save(BankAccount entity) {
        storage.put(entity.getAccountNumber(), entity);
    }

    @Override
    public Optional<BankAccount> findById(String s) {
        return Optional.ofNullable(storage.get(s));
    }

    @Override
    public List<BankAccount> findAll() {
        return List.copyOf(storage.values());
    }

    @Override
    public void deleteById(String s) {
        storage.remove(s);
    }

    @Override
    public boolean existsById(String s) {
        return storage.containsKey(s);
    }
}

// interface AccountRepository extends JpaRepository<BankAccount, String> { }


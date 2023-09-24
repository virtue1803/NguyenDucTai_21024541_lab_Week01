package com.iuh.fit.dev.nguyenductai_21024541_lab_week01.repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface IRepository<T> {
    boolean them(T t);
    boolean xoa(T t);
    boolean capNhat(T t);
    List<T> layDs();
    Optional<T> layTheoMa(Object...objects) throws Exception;
}

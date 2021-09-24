package com.xiaoyao.mysq.linterceptor.demo.converter;

import java.util.List;

/**
 * @author yls
 * @ClassName BaseConverter
 * @Description
 * @Date 2021/3/30 19:35
 * @Version 1.0
 */
public interface BaseConverter<T, E> {

  T toDTO(E e);

  List<T> toDTOList(List<E> e);

  E toEntity(T d);

  List<E> toEntityList(List<T> d);
}

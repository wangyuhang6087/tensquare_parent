package com.zhiyou100.base.service;

import com.zhiyou100.base.dao.LabelDao;
import com.zhiyou100.base.model.Label;
import com.zhiyou100.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:Rain
 * @date 2019/10/31 13:58
 * @desc
 */
@Service
public class LabelService {
    
    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll() {

        return labelDao.findAll();
    }

    public Label findById(String labelId) {

        return  labelDao.findById(labelId).get();// 加入get取出对象
    }

    public void add(Label label) {
        String id = idWorker.nextId() + "";
        label.setId(id);
        labelDao.save(label);
    }

    public void deleteById(String labelId) {
        labelDao.deleteById(labelId);
    }

    public void update(Label label) {
        // jpa中用save 更新
        labelDao.save(label);
    }

    public List findAllByKeyword(Label label) {
        //  JpaSpecificationExecutor 中的findAll方法
        // 需要传入Specification接口类型参数
        // 利用匿名内部类的形式 完成对该接口的实现,以及方法的 重写
        return  labelDao.findAll(new Specification<Label>() {
            /**
             *
             * @param root  根对象 : 要把条件封装到root对象,
             * @param query
             * @param criteriaBuilder  中的方法:like() 模糊查询
             *                         equal() 等值查询
             * @return
             */
            @Nullable
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) { // 百分号前后不用拼接 ' '
               List<Predicate> predicates = new ArrayList<>();
                if(label != null){
                    // 如果需要根据标签名模糊查询,那么先判断标签名是否为空.
                    if(!("".equals(label.getLabelname()) || null == label.getLabelname())){  // 拼接了 labelname like '%P%'
                        Predicate predicate1 = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                        predicates.add(predicate1);
                    }
                    if(!("".equals(label.getState()) || null == label.getState())){ // 拼接了state = 1
                        Predicate predicate2 = criteriaBuilder.equal(root.get("state").as(String.class), label.getState());
                        predicates.add(predicate2);
                    }
                    Predicate[] predicatesArray = predicates.toArray(new Predicate[predicates.size()]);
                    return criteriaBuilder.and(predicatesArray);
                }
                return null;
            }
        });
    }

     // 模糊查询+分页
    public Page<Label> findByKeywordAndPage(Label label, int page, int size) {
    // jpa提供了有分页的接口
        Pageable pageable = PageRequest.of(page -1, size);
        return  labelDao.findAll(new Specification<Label>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) { // 百分号前后不用拼接 ' '
                List<Predicate> predicates = new ArrayList<>();
                if(label != null){
                    // 如果需要根据标签名模糊查询,那么先判断标签名是否为空.
                    if(!("".equals(label.getLabelname()) || null == label.getLabelname())){  // 拼接了 labelname like '%P%'
                        Predicate predicate1 = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                        predicates.add(predicate1);
                    }
                    if(!("".equals(label.getState()) || null == label.getState())){ // 拼接了state = 1
                        Predicate predicate2 = criteriaBuilder.equal(root.get("state").as(String.class), label.getState());
                        predicates.add(predicate2);
                    }
                    Predicate[] predicatesArray = predicates.toArray(new Predicate[predicates.size()]);
                    return criteriaBuilder.and(predicatesArray);
                }
                return null;
            }
        },pageable);
    }
    
    public List<Label> findByRecommendEquals(String recommend) {

       return  labelDao.findByRecommendEquals(recommend);
    }
}

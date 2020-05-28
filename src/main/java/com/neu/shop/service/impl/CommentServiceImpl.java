package com.neu.shop.service.impl;

import com.neu.shop.dao.CommentMapper;
import com.neu.shop.pojo.Comment;
import com.neu.shop.pojo.CommentExample;
import com.neu.shop.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired(required = false)
    private CommentMapper commentMapper;

    @Override
    public void insertSelective(Comment comment){
        commentMapper.insertSelective(comment);
    }

    @Override
    public List<Comment> selectByExample(CommentExample commentExample) {
        return commentMapper.selectByExample(commentExample);
    }

    @Override
    public List<Comment> getCommentAndGoodsAndUser() {
        return commentMapper.getCommentAndGoodsAndUser();
    }

    @Override
    public int deleteComment(Integer commentId) {
        return commentMapper.deleteByPrimaryKey(commentId);
    }

}

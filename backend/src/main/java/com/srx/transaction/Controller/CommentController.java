package com.srx.transaction.Controller;

import com.srx.transaction.Entities.Comment;
import com.srx.transaction.Entities.DTO.ResultMessage;
import com.srx.transaction.Enum.ResultCode;
import com.srx.transaction.Serivce.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.srx.transaction.Enum.ResultCode.DATA_RETURN_SUCCESS;

/**
 * 这段代码是一个Spring Boot应用程序中的控制器类，用于处理与商品评论相关的HTTP请求。
 */
@RestController
@RequestMapping("/goods/comment")
public class CommentController {
    /**
     * 这行代码使用了@Autowired注解将CommentService注入到该控制器中。
     * CommentService是一个服务类，用于处理评论相关的业务逻辑。
     */
    @Autowired
    private CommentService commentService;

    /**
     * 这是一个处理HTTP POST请求的方法，路径为"/goods/comment/insertComment"。
     * 它接收一个Comment对象作为参数，并调用CommentService的insertComment方法来插入评论。
     * 根据插入操作的结果，返回一个ResultMessage对象，其中包含一个表示操作结果的ResultCode枚举值。
     * @param comment
     * @return
     */
    @PostMapping("/insertComment")
    public ResultMessage insertComment(Comment comment) {
        Boolean aBoolean = commentService.insertComment(comment);
        if (aBoolean) {
            return new ResultMessage(ResultCode.INSERT_COMMENT_SUCCESS);
        } else
            return new ResultMessage(ResultCode.INSERT_COMMENT_FAIL);
    }

    @GetMapping("/getCommentListByGoodsUUID")
    public ResultMessage getCommentListByGoodsUUID(@RequestParam String goodsUUID){
        List<Comment> commentListByUUID = commentService.getCommentListByUUID(goodsUUID);
        return new ResultMessage(DATA_RETURN_SUCCESS,commentListByUUID);
    }

    @GetMapping("/getCommentCount")
    public ResultMessage getCommentCount(@RequestParam String goodsUUID,String userId,String replyId){
        Comment comment=new Comment();
        comment.setGoodsUUID(goodsUUID);
        comment.setReplyId(replyId);
        comment.setUserId(userId);
        Integer integer = commentService.queryCommentCount(comment);
        Map<String,Integer> countMapper=new HashMap<>();
        countMapper.put("commentCount",integer);
        return new ResultMessage(DATA_RETURN_SUCCESS,countMapper);
    }
}

package com.company.userOrder.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.company.userOrder.domain.UserOrder;

@Mapper
public interface UserOrderMapper {
	
	@Insert("insert into userorder(createTime,userId,orderId,category,status,orderData,updateTime) values(#{createTime},#{userId},#{orderId},#{category},#{status},#{orderData},#{updateTime})")
	public void insertUserOrder(UserOrder userOrder);
	
	@Update("update userorder set category=#{category},status=#{status},orderData=#{orderData},updateTime=#{updateTime} where createTime=#{createTime},userId=#{userId},orderId=#{orderId}")
	public int updateUserOrder(UserOrder userOrder);
	
	
	@Update("update userorder set status=#{status},updateTime=#{updateTime} where createTime=#{createTime},userId=#{userId},orderId=#{orderId}")
	public int updateUserOrderStatus(UserOrder userOrder);
	
	
	@Delete("delete from  userorder  where createTime=#{createTime},userId=#{userId},orderId=#{orderId}")
	public int delUserOrder(UserOrder userOrder);
	
	@Select("select * from  userorder  where createTime=#{createTime},userId=#{userId},orderId=#{orderId}")
	public UserOrder selectUserOrderById(UserOrder userOrder);
	
	@Select("select * from  userorder  where createTime between #{startCreateTime} and #{endCreateTime} ,userId=#{userId} order by createTime desc,userid desc")
	public List<UserOrder> selOrdersByUser(@Param("startCreateTime") Date startCreateTime,@Param("endCreateTime") Date endCreateTime,@Param("userId") String userid);
	
	@Select("select * from  userorder  where createTime between #{startCreateTime} and #{endCreateTime} ,userId=#{userId} and status = #{status} order by createTime desc")
	public List<UserOrder> selOrderByUserStatus(@Param("startCreateTime") Date startCreateTime,@Param("endCreateTime") Date endCreateTime,@Param("userId") String userid,@Param("status") int status);
	
}

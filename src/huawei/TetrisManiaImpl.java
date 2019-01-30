package huawei;

import java.util.ArrayList;
import java.util.List;

import huawei.exam.*;

/**
 * 实现类
 * 
 * 各方法请按要求返回，考试框架负责报文输出
 */

public class TetrisManiaImpl implements ExamOp
{

	private int sys_time;
	private int[] queue=new int[10];
	private int current_building_block_order;
	private Panel panel;
	private int is_active;             //当前是否有活动积木,0表示当前panel内务活动积木
	/**
	 * ReturnCode(返回码枚举) .E001：非法命令 .E002：非法积木编号 .E003：非法移动距离 .E004：非法时间
	 * .E005：游戏结束 .E006：积木队列空间不足 .E007：游戏面板中不存在活动积木 .E008：操作时间不得小于系统时间
	 * .S001：操作成功
	 */

	/**
	 * Panel(游戏面板类) Panel(FillType[][] fillTypes)：构造函数，fillTypes - 填充类型矩阵
	 */

	/**
	 * FillType(填充类型枚举) .NONE：无积木填充 .FIXED：固定积木填充 .ACTIVE：活动积木填充
	 */

	/**
	 * Queue(积木队列类) Queue(int[] blocks)：构造函数，blocks - 积木编号数组
	 */

	/**
	 * 待考生实现，构造函数
	 */
	public TetrisManiaImpl()
	{
		this.is_active = 0; 
		this.panel=new Panel();
		this.sys_time = 0;
		for(int i=0; i< 10;i++) {
			this.queue[i] = 66;  // 66 means that the position in queue is empty.
		}
		this.current_building_block_order = 66;
	}

	public void Update () {
		if (is_active == 1) {}
		else {
			if (queue[0]!= 66) {
				is_active = 1;
				current_building_block_order = queue[0];
				for (int i=0; i<9;i++) {
					queue[i] = queue[i+1];
					queue[9] = 66;
				}
			}
		}
	}
	
	/**
	 * 将系统重置为初始状态
	 * 
	 * @return 返回码
	 */
	@Override
	public OpResult reset()
	{
		this.panel=new Panel();
		this.sys_time = 0;
		for(int i=0; i< 10;i++) {
			this.queue[i] = 66;  // 66 means that the position in queue is empty.
		}
		return new OpResult(ReturnCode.S001);
	}

	/**
	 * (1) 创建指定编号的一个或多个积木，新创建的积木按命令参数从左至右的顺序加入积木队列。此时若游戏面板中不存在活动积木，
	 * 系统从积木队列中取出居于首位的积木，在游戏面板中指定位置生成； (2) 积木编号取[0, 10]范围内的整数，值的合法性不作为考点，考生无须关注；
	 * (3) 命令携带参数个数取[1, 10]内的整数，值的合法性不作为考点，考生无须关注。
	 * 
	 * 
	 * @param ids
	 *            积木编号序列
	 * @return 返回码
	 */
	@Override
	public OpResult create(int[] ids)
	{
		// 创建积木之后
		//update();
		int i = 0;
		int j = 0;
		for(i = 0 ; i< 9;i++)
		{
			if(queue[i] == 66)
			{
			    queue[i] = ids[j];
			    length --;
			    if(length == 0)
			    {
			    	return new OpResult(ReturnCode.S001);
			    }
			    if(i==9 && length!=0)
			    {
			    	return new OpResult(ReturnCode.E006);
			    }
			}
		}
		
		return new OpResult(ReturnCode.E001);
	}

	/**
	 * (1) 将活动积木向左移动指定的距离，移动距离以宫格数量计量； (2)
	 * 在移动过程中，当活动积木中任一方块的左边界与游戏面板左边界或固定积木方块右边界接触时，活动积木无法继续左移，
	 * 系统对本次操作命令的处理终结，左移操作成功； (3)
	 * 因面板边界或其它积木阻挡导致实际可移动距离小于输入的移动距离时，活动积木只按实际距离移动并返回操作成功； (4)
	 * 左移距离取[1，8]范围内的整数，值的合法性不作为考点，考生无须关注。
	 * 
	 * 
	 * @param distance
	 *            移动距离
	 * @return 返回码
	 */
	@Override
	public OpResult moveLeft(int distance)
	{
		
		return new OpResult(ReturnCode.E001);
	}

	/**
	 * (1) 将活动积木向右移动指定的距离，移动距离以宫格数量计量； (2)
	 * 在移动过程中，当活动积木中任一方块的右边界与游戏面板右边界或固定积木方块左边界接触时，
	 * 活动积木无法继续右移，系统对本次操作命令的处理终结，右移操作成功； (3)
	 * 因面板边界或其它积木阻挡导致实际可移动距离小于输入的移动距离时，活动积木只按实际距离移动并返回操作成功； (4)
	 * 右移距离取[1，8]范围内的整数，值的合法性不作为考点，考生无须关注。
	 * 
	 * 
	 * @param distance
	 *            移动距离
	 * @return 返回码
	 */
	@Override
	public OpResult moveRight(int distance)
	{
		return new OpResult(ReturnCode.E001);
	}

	/**
	 * (1) 将活动积木向下移动指定的距离，移动距离以宫格数量计量； (2)
	 * 在移动过程中，当活动积木中任一方块的下边界与游戏面板下边界或固定积木方块上边界接触时，
	 * 活动积木无法继续下移，系统对本次操作命令的处理终结，下移操作成功； (3)
	 * 因面板边界或其它积木阻挡导致实际可移动距离小于输入的移动距离时，活动积木只按实际距离移动并变为固定积木，触发满行消除，操作返回成功； (4)
	 * 下移距离取[1，12]范围内的整数，值的合法性不作为考点，考生无须关注。
	 * 
	 * 
	 * @param distance
	 *            移动距离
	 * @return 返回码
	 */
	@Override
	public OpResult moveDown(int distance)
	{
		return new OpResult(ReturnCode.E001);
	}

	/**
	 * (1) 将活动积木顺时针旋转一次； (2) 活动积木无法旋转时，保持当前位置与形态不变。
	 * 
	 * @return 返回码
	 */
	@Override
	public OpResult rotate()
	{
	    int i = 0;
	    int j = 0;
		int[] is_break_loop = new int[11];  //is_break_loop 用于判定是否跳出双层for循环
		for ( i =0; i< 10 ; i++)
		{
			is_break_loop[i] = 0;
		}
		switch(current_building_block_order) {
		case 0: break;
		
		case 1:   // 检测活动积木左上角的位置

				for( i = 0; i< 12;i++)
			     {
					for(j = 0; j<8; j++) 
					{
						if (this.panel.table[i][j] == Element.star)
						{
							is_break_loop[1]=1;
							break;
						}
					}
					if(is_break_loop[1] == 1){
						break;
					}
			     }
				if(this.panel.table[i+1][j] == Element.star) 
				{
					if(this.panel.table[i][j+1] == Element.star)  
					{
						if(this.panel.table[i+1][j+1] == Element.star)
						{  								//旋转两次
							this.panel.table[i+1][j] = Element.point;
							this.panel.table[i+1][j+1] = Element.star;
						}
						else 							
						{								//初始状态
						this.panel.table[i+1][j] = Element.point;
						this.panel.table[i+1][j+1] = Element.star;
						}
					}
					else    					//旋转3次状态
					{
						this.panel.table[i][j+1] = Element.star;
						this.panel.table[i+1][j+1] = Element.point;
					}
				}
				else  							// 旋转一次状态
				{
					this.panel.table[i+1][j] = Element.star;
					this.panel.table[i][j] = Element.point;
			    }
				break;
		case 2: 
			 for(i=0; i< 12;i++)
		     {
				for(j=0; j<8; j++) 
				{
					if (this.panel.table[i][j] == Element.star)
					{
						is_break_loop[2]=1;
						break;
					}
				}
				if(is_break_loop[2] == 1){
					break;
				}
		     }
			 if(this.panel.table[i][j+1] == Element.star) 
				{ 								//初始状态 旋转2
					this.panel.table[i][j-1] = Element.star;
					this.panel.table[i][j+1] = Element.point;
					this.panel.table[i+2][j-1] = Element.point;
					this.panel.table[i+2][j-1] = Element.star;
				}
			 else 
			 {								    //旋转1/3
					this.panel.table[i+2][j] = Element.star;
					this.panel.table[i][j] = Element.point;
					this.panel.table[i+2][j+2] = Element.point;
					this.panel.table[i][j+2] = Element.star;
			 }
			 break;
		
		
		case 3: break;
		
		case 4:
			 for(i=0; i< 12;i++)
		     {
				for(j=0; j<8; j++) 
				{
					if (this.panel.table[i][j] == Element.star)
					{
						is_break_loop[4] = 1;
						break;
					}
				}
				if(is_break_loop[4] == 1){
					break;
				}
		     }
			 if(this.panel.table[i+2][j+2] == Element.star)
			 {
				 if(this.panel.table[i+2][j] == Element.star)
				 {
					 this.panel.table[i+2][j+2] = Element.point; //rotate 3
					 this.panel.table[i][j+2] = Element.star; 
				 }
				 else
				 {
					 this.panel.table[i][j] = Element.point;   // rotate 1
					 this.panel.table[i+2][j] = Element.star;  
				 }
			 }
			 else
			 {
				 if(this.panel.table[i+1][j-1] == Element.star)
				 {
					 this.panel.table[i][j-1] = Element.star;   // rotate 2
					 this.panel.table[i][j+1] = Element.point; 
				 }
				 else
				 {
					 this.panel.table[i][j+2] = Element.point;   // rotate 0
					 this.panel.table[i+2][j+2] = Element.star;
				 }
			 }
			 
		case 5: 	 
			 for(i=0; i< 12;i++)
		     {
				for(j=0; j<8; j++) 
				{
					if (this.panel.table[i][j] == Element.star)
					{
						is_break_loop[4] = 1;
						break;
					}
				}
				if(is_break_loop[4] == 1){
					break;
				}
		     }
			 if( this.panel.table[i+1][j-1] == Element.star)
			 {
				 this.panel.table[i][j-1] = Element.star;   // rotate 0
				 this.panel.table[i][j+1] = Element.point; 
			 }
			 else
			 {
				 if(this.panel.table[i+2][j] == Element.star)
				 {
					 this.panel.table[i][j+2] = Element.star;   // rotate 3
					 this.panel.table[i][j] = Element.point;			 
				 }
				 else if(this.panel.table[i][j+2] == Element.star)
				 {
					 this.panel.table[i][j+2] = Element.point;   // rotate 2
					 this.panel.table[i+2][j+2] = Element.star;
				 }
			 }
			 break;
			 
		case 6:
			for(i=0; i< 12;i++)
		     {
				for(j=0; j<8; j++) 
				{
					if (this.panel.table[i][j] == Element.star)
					{
						is_break_loop[4] = 1;
						break;
					}
				}
				if(is_break_loop[4] == 1){
					break;
				}
		     }
			 if( this.panel.table[i+1][j] != Element.star)
			 {
				 this.panel.table[i][j] = Element.point;   // rotate 1
				 this.panel.table[i][j+1] = Element.point; 
				 this.panel.table[i+1][j] = Element.star;   // rotate 1
				 this.panel.table[i+1][j] = Element.star;
			 }
			 else
			 {
				 if(this.panel.table[i][j+1] == Element.point)
				 {
					 this.panel.table[i][j+2] = Element.point;   // rotate 2
					 this.panel.table[i+1][j+2] = Element.point;	
					 this.panel.table[i][j] = Element.star;   // rotate 2
					 this.panel.table[i][j+1] = Element.star;
				 }
				 else if(this.panel.table[i+2][j+2] == Element.star)
				 {
					 this.panel.table[i+2][j+2] = Element.point;   // rotate 3
					 this.panel.table[i+1][j+2] = Element.point;
					 this.panel.table[i][j+2] = Element.star;   // rotate 3
					 this.panel.table[i+1][j+2] = Element.star;
				 }
				 else
				 {
					 this.panel.table[i+1][j] = Element.point;   // rotate 0
					 this.panel.table[i+2][j] = Element.point;
					 this.panel.table[i+2][j+1] = Element.star;   // rotate 0
					 this.panel.table[i+2][j+2] = Element.star;
				 }
			 }
			 break;
		
		case 7: 	 
			 for(i=0; i< 12;i++)
		     {
				for(j=0; j<8; j++) 
				{
					if (this.panel.table[i][j] == Element.star)
					{
						is_break_loop[4] = 1;
						break;
					}
				}
				if(is_break_loop[4] == 1){
					break;
				}
		     }
			 if( this.panel.table[i+2][j-1] != Element.star)
			 {
				 this.panel.table[i][j] = Element.star;   
				 this.panel.table[i+1][j] = Element.star; 
				 this.panel.table[i][j+1] = Element.point;   // rotate 0
				 this.panel.table[i][j+2] = Element.point;
			 }
			 else
			 {
				 if(this.panel.table[i][j+1] == Element.point)
				 {
					 this.panel.table[i][j+1] = Element.star;   // rotate 1
					 this.panel.table[i][j+2] = Element.star;	
					 this.panel.table[i+1][j+2] = Element.point;  
					 this.panel.table[i+2][j+2] = Element.point;
				 }
				 else if(this.panel.table[i+2][j+2] == Element.star)
				 {
					 this.panel.table[i+2][j] = Element.point;   // rotate 3
					 this.panel.table[i+2][j+1] = Element.point;
					 this.panel.table[i][j] = Element.star;   
					 this.panel.table[i+1][j] = Element.star;
				 }
				 else
				 {
					 this.panel.table[i+2][j] = Element.point;   
					 this.panel.table[i+2][j+1] = Element.point;
					 this.panel.table[i+1][j+2] = Element.star;   // rotate 2
					 this.panel.table[i+2][j+2] = Element.star;
				 }
			 }
			 break;
			 
			 
		case 8: 	 
			 for(i=0; i< 12;i++)
		     {
				for(j=0; j<8; j++) 
				{
					if (this.panel.table[i][j] == Element.star)
					{
						is_break_loop[4] = 1;
						break;
					}
				}
				if(is_break_loop[4] == 1){
					break;
				}
		     }
			 
			 if( this.panel.table[i+1][j-1] == Element.point)
			 {
				 this.panel.table[i][j] = Element.star;  
				 this.panel.table[i+2][j+2] = Element.star; 
				 this.panel.table[i+2][j+3] = Element.star; 
				 this.panel.table[i+3][j+2] = Element.star;
				 this.panel.table[i+3][j+3] = Element.star;
				 this.panel.table[i+2][j] = Element.point;   // rotate 0
				 this.panel.table[i+3][j] = Element.point;
				 this.panel.table[i][j+3] = Element.point;   
				 this.panel.table[i+3][j+1] = Element.point;
				 this.panel.table[i+2][j+1] = Element.point; 

			 }
			 else
			 {
				 if(this.panel.table[i+3][j] == Element.star)
				 {
					 this.panel.table[i][j-1] = Element.star;  
					 this.panel.table[i][j-2] = Element.star; 
					 this.panel.table[i+1][j-1] = Element.star; 
					 this.panel.table[i+1][j+2] = Element.star;
					 this.panel.table[i+3][j+1] = Element.star;
					 this.panel.table[i][j] = Element.point;   // rotate 2
					 this.panel.table[i+1][j] = Element.point;
					 this.panel.table[i][j+1] = Element.point;   
					 this.panel.table[i+1][j+1] = Element.point;
					 this.panel.table[i+3][j-2] = Element.point; 
					 
				 }
				 else if(this.panel.table[i+2][j] == Element.star)
				 {
					 this.panel.table[i][j] = Element.point;  
					 this.panel.table[i+2][j+2] = Element.point; 
					 this.panel.table[i+2][j+3] = Element.point; 
					 this.panel.table[i+3][j+2] = Element.point;
					 this.panel.table[i+3][j+3] = Element.point;
					 this.panel.table[i+3][j] = Element.star;   // rotate 3
					 this.panel.table[i][j+2] = Element.star;
					 this.panel.table[i][j+3] = Element.star;   
					 this.panel.table[i+1][j+2] = Element.star;
					 this.panel.table[i+1][j+3] = Element.star; 
				 }
				 else
				 {
					 this.panel.table[i][j] = Element.point;  
					 this.panel.table[i+2][j+2] = Element.point; 
					 this.panel.table[i+2][j+3] = Element.point; 
					 this.panel.table[i+3][j+2] = Element.point;
					 this.panel.table[i+3][j+3] = Element.point;
					 this.panel.table[i+3][j] = Element.star;   // rotate 3
					 this.panel.table[i][j+2] = Element.star;
					 this.panel.table[i][j+3] = Element.star;   
					 this.panel.table[i+1][j+2] = Element.star;
					 this.panel.table[i+1][j+3] = Element.star; 
				 }
			 }
			 
			 break;
			 
		case 9: 	 
			 for(i=0; i< 12;i++)
		     {
				for(j=0; j<8; j++) 
				{
					if (this.panel.table[i][j] == Element.star)
					{
						is_break_loop[4] = 1;
						break;
					}
				}
				if(is_break_loop[4] == 1){
					break;
				}
		     }
			 
			 if(this.panel.table[i+2][j+2] == Element.star)
			 {
				 if(this.panel.table[i+2][j] == Element.star)
				 {
					 this.panel.table[i+2][j+2] = Element.point; //rotate 3
					 this.panel.table[i][j+2] = Element.star; 
				 }
				 else
				 {
					 this.panel.table[i][j] = Element.point;   // rotate 1
					 this.panel.table[i+2][j] = Element.star;  
				 }
			 }
			 else
			 {
				 if(this.panel.table[i+1][j-1] == Element.star)
				 {
					 this.panel.table[i][j-1] = Element.star;   // rotate 2
					 this.panel.table[i][j+1] = Element.point; 
				 }
				 else
				 {
					 this.panel.table[i][j+2] = Element.point;   // rotate 0
					 this.panel.table[i+2][j+2] = Element.star;
				 }
			 }
			 
			 break;
			 
		case 10: 	break;
		}	
		return new OpResult(ReturnCode.E001);
	}

	/**
	 * (1) 时间不小于当前系统时间时，优先触发系统时间更新至命令携带的时间，在指定时间点对游戏面板进行查询，； (2)
	 * 时间取[0,1000]范围内整数，值的合法性不作为考点，考生无须关注； (3)
	 * 本命令不受游戏进度影响，即使游戏结束，命令依然生效，将系统时间更新至输入的时间并输出查询结果。
	 * 
	 * @param time
	 *            时间
	 * @return 查询结果
	 */
	@Override
	public OpResult queryPanel(int time)
	{
		return new OpResult(ReturnCode.E001);
	}

	/**
	 * 查询积木队列
	 * 
	 * @param time
	 *            时间
	 * @return 查询结果
	 */
	@Override
	public OpResult queryQueue(int time)
	{
		return new OpResult(ReturnCode.E001);
	}


}

package huawei;

import java.util.ArrayList;
import java.util.List;

import huawei.exam.*;

/*
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
	private int is_active;                      //当前是否有活动积木,0表示当前panel内务活动积木
	private int is_end;                         //当前游戏结束条件，
	/*
	 * ReturnCode(返回码枚举) .E001：非法命令 .E002：非法积木编号 .E003：非法移动距离 .E004：非法时间
	 * .E005：游戏结束 .E006：积木队列空间不足 .E007：游戏面板中不存在活动积木 .E008：操作时间不得小于系统时间
	 * .S001：操作成功
	 */

	/*
	 * Panel(游戏面板类) Panel(FillType[][] fillTypes)：构造函数，fillTypes - 填充类型矩阵
	 */

	/*
	 * FillType(填充类型枚举) .NONE：无积木填充 .FIXED：固定积木填充 .ACTIVE：活动积木填充
	 */

	/*
	 * Queue(积木队列类) Queue(int[] blocks)：构造函数，blocks - 积木编号数组
	 */

	/*
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
				current_building_block_order = queue[0];
				switch (current_building_block_order){
					case 0:
						if(this.panel.table[0][3] == Element.point ){
							is_active = 1;                           // 需要判断确实能够放下初始积木，然后更新当前面板，并且将is_active设置为1，如果无法放下积木，则游戏结束，将is_end设置为1.
							this.panel.table[0][3] = Element.star;
						}
						else
						{
							is_end = 1;
						}
						break;
					case 1:
						if(this.panel.table[0][3] == Element.point && this.panel.table[0][4] == Element.point && this.panel.table[1][3] == Element.point){
							is_active = 1;
							this.panel.table[0][3] = Element.star;
							this.panel.table[0][4] = Element.star;
							this.panel.table[1][3] = Element.star;
						}
						else
						{
							is_end = 1;
						}
						break;
					case 2:
						if(this.panel.table[0][3] == Element.point && this.panel.table[0][4] == Element.point && this.panel.table[1][2] == Element.point && this.panel.table[1][3] == Element.point && this.panel.table[1][4] == Element.point && this.panel.table[2][2] == Element.point && this.panel.table[2][3] == Element.point )
						{
							this.panel.table[0][3] = Element.star;
							this.panel.table[0][4] = Element.star;
							this.panel.table[1][2] = Element.star;
							this.panel.table[1][3] = Element.star;
							this.panel.table[1][4] = Element.star;
							this.panel.table[2][2] = Element.star;
							this.panel.table[2][3] = Element.star;
							is_active = 1;
						}
						else{
							is_end = 1;
						}
						break;
					case 3:
						if(this.panel.table[0][3] == Element.point && this.panel.table[0][4] == Element.point && this.panel.table[1][3] == Element.point && this.panel.table[1][4] == Element.point ){
							this.panel.table[0][3] = Element.star;
							this.panel.table[0][4] = Element.star;
							this.panel.table[1][3] = Element.star;
							this.panel.table[1][4] = Element.star;
							is_active = 1;
						}
						else{
							is_end = 1;
						}
						break;
					case 4:
						if(this.panel.table[0][3] == Element.point && this.panel.table[0][4] == Element.point && this.panel.table[0][5] == Element.point && this.panel.table[1][3] == Element.point && this.panel.table[1][4] == Element.point  && this.panel.table[1][5] == Element.point && this.panel.table[2][3] == Element.point && this.panel.table[2][4] == Element.point )
						{
							this.panel.table[0][3] = Element.star;
							this.panel.table[0][4] = Element.star;
							this.panel.table[0][5] = Element.star;
							this.panel.table[1][3] = Element.star;
							this.panel.table[1][4] = Element.star;
							this.panel.table[1][5] = Element.star;
							this.panel.table[0][3] = Element.star;
							this.panel.table[0][4] = Element.star;
							is_active = 1;
						}
						else{
							is_end = 1;
						}
						break;
					case 5:
						if(this.panel.table[0][3] == Element.point && this.panel.table[0][4] == Element.point && this.panel.table[1][2] == Element.point && this.panel.table[1][3] == Element.point && this.panel.table[1][4] == Element.point  && this.panel.table[2][2] == Element.point && this.panel.table[2][3] == Element.point && this.panel.table[2][4] == Element.point ) {
							this.panel.table[0][3] = Element.star;
							this.panel.table[0][4] = Element.star;
							this.panel.table[1][2] = Element.star;
							this.panel.table[1][3] = Element.star;
							this.panel.table[1][4] = Element.star;
							this.panel.table[2][2] = Element.star;
							this.panel.table[2][3] = Element.star;
							this.panel.table[2][4] = Element.star;
							is_active = 1;
						}
						else{
							is_end = 1;
						}
						break;
					case 6:
						if(this.panel.table[0][3] == Element.point && this.panel.table[0][4] == Element.point && this.panel.table[0][5] == Element.point && this.panel.table[1][3] == Element.point && this.panel.table[1][4] == Element.point  && this.panel.table[1][5] == Element.point && this.panel.table[2][3] == Element.point ) {
							this.panel.table[0][3] = Element.star;
							this.panel.table[0][4] = Element.star;
							this.panel.table[0][5] = Element.star;
							this.panel.table[1][3] = Element.star;
							this.panel.table[1][4] = Element.star;
							this.panel.table[1][5] = Element.star;
							this.panel.table[2][3] = Element.star;
							is_active = 1;
						}
						else{
							is_end = 1;
						}
						break;
					case 7:
						if(this.panel.table[0][3] == Element.point && this.panel.table[0][4] == Element.point && this.panel.table[1][3] == Element.point && this.panel.table[1][4] == Element.point && this.panel.table[2][3] == Element.point  && this.panel.table[2][3] == Element.point && this.panel.table[2][4] == Element.point ) {
							this.panel.table[0][3] = Element.star;
							this.panel.table[0][4] = Element.star;
							this.panel.table[1][3] = Element.star;
							this.panel.table[1][4] = Element.star;
							this.panel.table[2][2] = Element.star;
							this.panel.table[2][3] = Element.star;
							this.panel.table[2][4] = Element.star;
							is_active = 1;
						}
						else{
							is_end = 1;
						}
						break;
					case 8:
						if(this.panel.table[0][3] == Element.point && this.panel.table[0][4] == Element.point && this.panel.table[0][5] == Element.point && this.panel.table[1][2] == Element.point && this.panel.table[1][3] == Element.point  && this.panel.table[1][4] == Element.point && this.panel.table[1][5] == Element.point && this.panel.table[2][2] == Element.point && this.panel.table[2][3] == Element.point && this.panel.table[3][2] == Element.point && this.panel.table[3][3] == Element.point) {
							this.panel.table[0][3] = Element.star;
							this.panel.table[0][4] = Element.star;
							this.panel.table[0][5] = Element.star;
							this.panel.table[1][2] = Element.star;
							this.panel.table[1][3] = Element.star;
							this.panel.table[1][4] = Element.star;
							this.panel.table[1][5] = Element.star;
							this.panel.table[2][2] = Element.star;
							this.panel.table[2][3] = Element.star;
							this.panel.table[3][2] = Element.star;
							this.panel.table[3][3] = Element.star;
							is_active = 1;
						}
						else{
							is_end = 1;
						}
						break;

					case 9:
						if(this.panel.table[0][3] == Element.point && this.panel.table[0][4] == Element.point && this.panel.table[0][5] == Element.point && this.panel.table[1][3] == Element.point && this.panel.table[1][4] == Element.point  && this.panel.table[1][5] == Element.point && this.panel.table[2][3] == Element.point && this.panel.table[2][4] == Element.point  ) {
							this.panel.table[0][3] = Element.star;
							this.panel.table[0][4] = Element.star;
							this.panel.table[0][5] = Element.star;
							this.panel.table[1][3] = Element.star;
							this.panel.table[1][4] = Element.star;
							this.panel.table[1][5] = Element.star;
							this.panel.table[2][3] = Element.star;
							this.panel.table[2][4] = Element.star;
							is_active = 1;
						}
						else{
							is_end = 1;
						}
						break;
					case 10:
						if(this.panel.table[0][3] == Element.point && this.panel.table[0][4] == Element.point && this.panel.table[1][3] == Element.point && this.panel.table[1][4] == Element.point ){
							this.panel.table[0][3] = Element.star;
							this.panel.table[0][4] = Element.star;
							this.panel.table[1][3] = Element.star;
							this.panel.table[1][4] = Element.star;
							is_active = 1;
						}
						else{
							is_end = 1;
						}
						break;
				}
				if(is_active == 1) {
					for (int i = 0; i < 9; i++) {
						queue[i] = queue[i + 1];
						queue[9] = 66;
					}
				}

			}
		}
	}
	
	/*
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

	/*
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
		int i = 0;
		int j = 0;
		int length = ids.length;
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

	/*
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
	public OpResult moveLeft(int distance)
	{
		// 首先判断活动积木的行列索引
		// 再判断当前的旋转状态。

		int row = 0;      // 当前活动元素的左上角元素行列索引(row,column)
		int column = 0;
		int rotate_state;  //旋转次数 用于帮助判断积木在图中位置
		int is_break_loop =0;


		if(is_end == 1)  //判断当前是否已经游戏结束
			return new OpResult(ReturnCode.E005);
		if(is_active == 0)   // 判断当前是否还有可活动积木
			return new OpResult(ReturnCode.E007);

		//游戏未结束且有可活动积木时方可进行move left 操作
		//首先取出当前状态下积木的左上角的坐标
		for( row = 0; row< 12; row++)
		{
			for(column = 0; column<8; column++)
			{
				if (this.panel.table[row][column] == Element.star)
				{
					is_break_loop=1;
					break;
				}
			}
			if(is_break_loop == 1){
				break;
			}
		}
		//判断积木旋转次数
		rotate_state = judge_rotate_state(row,column);

		//根据积木标号和旋转次数，将积木位置在面板中标出
		if(current_building_block_order == 0)     //0号积木
			this.panel.table[row][column] = Element.star;

		if(current_building_block_order == 1)     //1号积木
		{
			if(rotate_state == 0 || rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
			};

			if(rotate_state == 1 || rotate_state == 3)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
			};

		};

		if(current_building_block_order == 2)     //2号积木
		{
			if(rotate_state == 0 || rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+2][column] = Element.star;
			};

			if(rotate_state == 1 || rotate_state == 3)      //3号积木
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row][column+2] = Element.star;
			};

		};

		if(current_building_block_order == 4)      //4号积木
		{
			if(rotate_state == 0)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row+1][column+1] = Element.star;
				this.panel.table[row+2][column+1] = Element.star;
			};

			if(rotate_state == 1)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+1][column-1] = Element.star;
				this.panel.table[row+1][column-2] = Element.star;
			};
			if(rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+2][column] = Element.star;
				this.panel.table[row+3][column] = Element.star;
			};
			if(rotate_state == 3)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row][column+2] = Element.star;
				this.panel.table[row+1][column] = Element.star;
			};

		};

		if(current_building_block_order == 5)      //5号积木
		{
			if(rotate_state == 0)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+2][column] = Element.star;
			};

			if(rotate_state == 1)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row][column+2] = Element.star;
				this.panel.table[row+1][column-2] = Element.star;
			};
			if(rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+2][column] = Element.star;
				this.panel.table[row+3][column] = Element.star;
			};
			if(rotate_state == 3)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row][column+2] = Element.star;
				this.panel.table[row+1][column] = Element.star;
			};

		};

		if(current_building_block_order == 6)      //6号积木
		{
			if(rotate_state == 0 || rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+1][column-1] = Element.star;
				this.panel.table[row+2][column-1] = Element.star;
			};

			if(rotate_state == 1 || rotate_state == 3)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row+1][column+1] = Element.star;
				this.panel.table[row+1][column+2] = Element.star;
			};

		};

		if(current_building_block_order == 7)     //7号积木
		{
			if(rotate_state == 0 || rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+1][column+1] = Element.star;
				this.panel.table[row+2][column+1] = Element.star;
			};

			if(rotate_state == 1 || rotate_state == 3)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+1][column-1] = Element.star;
			};

		};

		if(current_building_block_order == 8)     //8号积木
		{
			if(rotate_state == 0 || rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+2][column] = Element.star;
				this.panel.table[row+3][column] = Element.star;
			};

			if(rotate_state == 1 || rotate_state == 3)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row][column+2] = Element.star;
				this.panel.table[row][column+3] = Element.star;
			};

		};

		if(current_building_block_order == 5)      //9号积木
		{
			if(rotate_state == 0)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column-1] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+2][column] = Element.star;
			};

			if(rotate_state == 1)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column+1] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+1][column-1] = Element.star;
			};
			if(rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+1][column+1] = Element.star;
				this.panel.table[row+2][column] = Element.star;
			};
			if(rotate_state == 3)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row][column+2] = Element.star;
				this.panel.table[row+1][column+1] = Element.star;
			};

		};

		if(current_building_block_order == 10)      //10号积木
		{
			this.panel.table[row][column] = Element.star;
		};

		outer:
		for(int current_dis=0; current_dis < distance; current_dis++)  //动态判断左移是否结束
		{
			for(int i=0;i<12;i++)   //判断活动积木左侧是否紧邻固定积木，若是则移动结束，否则继续
				for(int j=0;j<8;j++)
					if(this.panel.table[i][j] == Element.star && this.panel.table[i][j-1] == Element.X) //活动积木左侧有面板，移动结束
						break outer;

			for(int i=0;i<12;i++)  //若可继续左移，则对面板进行更新
				for(int j=1;j<8;j++)
					if(this.panel.table[i][j] == Element.star)
					{
						this.panel.table[i][j] = Element.point;
						this.panel.table[i][j-1] = Element.star;
					};
		}

		Update();    // 更新活动积木。
		return new OpResult(ReturnCode.S001);
	}


	public int judge_rotate_state(int row, int column){

		int[] is_break_loop = new int[11];  //is_break_loop 用于判定是否跳出双层for循环
		for (int i =0; i< 10 ; i++)
		{
			is_break_loop[i] = 0;
		}
		switch(current_building_block_order) {
			case 0: return 0;
			case 1:   // 检测活动积木左上角的位置
				if(this.panel.table[row+1][column] == Element.star)
				{
					if(this.panel.table[row][column+1] == Element.star)
					{
						if(this.panel.table[row+1][column+1] == Element.star)
						{
							return 2;//旋转两次
						}
						else
						{								//初始状态
							return 0;
						}
					}
					else    					//旋转3次状态
					{
						return 3;
					}
				}
				else  							// 旋转一次状态
				{
					return 1;
				}

			case 2:

				if(this.panel.table[row][column+1] == Element.star)
				{ 								//初始状态 旋转2
					return 0;
				}
				else {                                    //旋转1/3
					return 1;
				}


			case 3: return 0;

			case 4:

				if(this.panel.table[row+2][column+2] == Element.star)
				{
					if(this.panel.table[row+2][column] == Element.star)
					{
						return 3; //rotate 3
					}
					else
					{
						return 1;  // rotate 1
					}
				}
				else
				{
					if(this.panel.table[row+1][column-1] == Element.star)
					{
						return 2;   // rotate 2
					}
					else
					{
						return 0;  // rotate 0
					}
				}

			case 5:   //########################################################################！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！

				if( this.panel.table[row+1][column-1] == Element.star)
				{
					return 0;   // rotate 0
				}
				else
				{
					if(this.panel.table[row+2][column] == Element.star && this.panel.table[row][column+2] == Element.star)
					{
						return 2;   // rotate 2   //########################################################################！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
					}
					else if(this.panel.table[row][column+2] == Element.star && this.panel.table[row+2][column+2] == Element.star)
					{
						return 3;   // rotate 3   //########################################################################！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
					}
					else if(this.panel.table[row+2][column] == Element.star && this.panel.table[row+2][column+2] == Element.star)
					{
						return 1;   // rotate 1   //########################################################################！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
					}
				}

			case 6:

				if( this.panel.table[row+1][column] != Element.star)
				{
				 // rotate 1
					 return 1;
				}
				else {
					if (this.panel.table[row][column + 1] == Element.point) {
						return 2;  // rotate 2
					} else if (this.panel.table[row + 2][column + 2] == Element.star) {
						return 3;  // rotate 3
					} else {
						return 0;  // rotate 0
					}
				}

			case 7:

				if( this.panel.table[row+2][column-1] != Element.star)
				{
					return 0;  // rotate 0
				}
				else
				{
					if(this.panel.table[row][column+1] == Element.point)
					{
						return 1;   // rotate 1
					}
					else if(this.panel.table[row+2][column+2] == Element.star)
					{
						return 3;  // rotate 3
					}
					else
					{
						return 2;   // rotate 2
					}
				}


			case 8:

				if( this.panel.table[row+1][column-1] == Element.point)
				{
					return 0;  // rotate 0
				}
				else
				{
					if(this.panel.table[row+3][column] == Element.star && this.panel.table[row+3][column-2] == Element.star)
					{
						return 2;  // rotate 2
					}
					else if(this.panel.table[row+3][column+3] == Element.star && this.panel.table[row+3][column+1] == Element.star)
					{
						return 3;  // rotate 3
					}
					else if(this.panel.table[row+1][column+3] == Element.star)
					{
						return 1;   // rotate 1
					}
				}
				break;

			case 9:

				if(this.panel.table[row+2][column+2] == Element.star && this.panel.table[row+2][column] == Element.star)
				{
					return 3; //rotate 3
				}
				else if (this.panel.table[row + 2][column+2] == Element.star && this.panel.table[row][column+2] == Element.star) {
					return 1;  // rotate 1
				}
				else if(this.panel.table[row + 2][column - 1] == Element.star)
				{
					return 2; // rotate 2
				}
				else if(this.panel.table[row + 2][column] == Element.star && this.panel.table[row][column+2] == Element.star)
				{
					return 0; // rotate 0
				}
				break;

			case 10: 	return 0;
		}
		return 9;        // 当前没有活动积木，或者错误情况下
	}
	/*
	 * (1)将活动积木向右移动指定的距离，移动距离以宫格数量计量； (2)
	 * 在移动过程中，当活动积木中任一方块的右边界与游戏面板右边界或固定积木方块左边界接触时，
	 * 活动积木无法继续右移，系统对本次操作命令的处理终结，右移操作成功； (3)
	 * 因面板边界或其它积木阻挡导致实际可移动距离小于输入的移动距离时，活动积木只按实际距离移动并返回操作成功； (4)
	 * 右移距离取[1，8]范围内的整数，值的合法性不作为考点，考生无须关注。
	 * 
	 * 
	 * @param distance
	 *            移动距离
	 * @return 返回码
	 *
	 *
	 * /
	 *//
	@Override
	public OpResult moveRight(int distance)
	{
		// 首先判断活动积木的行列索引
		// 再判断当前的旋转状态。

		int row = 0;      // 当前活动元素的左上角元素行列索引(row,column)
		int column = 0;
		int rotate_state;  //旋转次数 用于帮助判断积木在图中位置
		int is_break_loop =0;


		if(is_end == 1)  //判断当前是否已经游戏结束
			return new OpResult(ReturnCode.E005);
		if(is_active == 0)   // 判断当前是否还有可活动积木
			return new OpResult(ReturnCode.E007);

		//游戏未结束且有可活动积木时方可进行move left 操作
		//首先取出当前状态下积木的左上角的坐标
		for( row = 0; row< 12; row++)
		{
			for(column = 0; column<8; column++)
			{
				if (this.panel.table[row][column] == Element.star)
				{
					is_break_loop=1;
					break;
				}
			}
			if(is_break_loop == 1){
				break;
			}
		}
		//判断积木旋转次数
		rotate_state = judge_rotate_state(row,column);

		//根据积木标号和旋转次数，将积木位置在面板中标出
		if(current_building_block_order == 0)     //0号积木
			this.panel.table[row][column] = Element.star;

		if(current_building_block_order == 1)     //1号积木
		{
			if(rotate_state == 0 || rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
			};

			if(rotate_state == 1 || rotate_state == 3)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
			};

		};

		if(current_building_block_order == 2)     //2号积木
		{
			if(rotate_state == 0 || rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+2][column] = Element.star;
			};

			if(rotate_state == 1 || rotate_state == 3)      //3号积木
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row][column+2] = Element.star;
			};

		};

		if(current_building_block_order == 4)      //4号积木
		{
			if(rotate_state == 0)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row+1][column+1] = Element.star;
				this.panel.table[row+2][column+1] = Element.star;
			};

			if(rotate_state == 1)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+1][column-1] = Element.star;
				this.panel.table[row+1][column-2] = Element.star;
			};
			if(rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+2][column] = Element.star;
				this.panel.table[row+3][column] = Element.star;
			};
			if(rotate_state == 3)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row][column+2] = Element.star;
				this.panel.table[row+1][column] = Element.star;
			};

		};

		if(current_building_block_order == 5)      //5号积木
		{
			if(rotate_state == 0)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+2][column] = Element.star;
			};

			if(rotate_state == 1)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row][column+2] = Element.star;
				this.panel.table[row+1][column-2] = Element.star;
			};
			if(rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+2][column] = Element.star;
				this.panel.table[row+3][column] = Element.star;
			};
			if(rotate_state == 3)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row][column+2] = Element.star;
				this.panel.table[row+1][column] = Element.star;
			};

		};

		if(current_building_block_order == 6)      //6号积木
		{
			if(rotate_state == 0 || rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+1][column-1] = Element.star;
				this.panel.table[row+2][column-1] = Element.star;
			};

			if(rotate_state == 1 || rotate_state == 3)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row+1][column+1] = Element.star;
				this.panel.table[row+1][column+2] = Element.star;
			};

		};

		if(current_building_block_order == 7)     //7号积木
		{
			if(rotate_state == 0 || rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+1][column+1] = Element.star;
				this.panel.table[row+2][column+1] = Element.star;
			};

			if(rotate_state == 1 || rotate_state == 3)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+1][column-1] = Element.star;
			};

		};

		if(current_building_block_order == 8)     //8号积木
		{
			if(rotate_state == 0 || rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+2][column] = Element.star;
				this.panel.table[row+3][column] = Element.star;
			};

			if(rotate_state == 1 || rotate_state == 3)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row][column+2] = Element.star;
				this.panel.table[row][column+3] = Element.star;
			};

		};

		if(current_building_block_order == 9)      //9号积木
		{
			if(rotate_state == 0)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column-1] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+2][column] = Element.star;
			};

			if(rotate_state == 1)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column+1] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+1][column-1] = Element.star;
			};
			if(rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+1][column+1] = Element.star;
				this.panel.table[row+2][column] = Element.star;
			};
			if(rotate_state == 3)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row][column+2] = Element.star;
				this.panel.table[row+1][column+1] = Element.star;
			};

		};

		if(current_building_block_order == 10)      //10号积木
		{
			this.panel.table[row][column] = Element.star;
		};

		outer:
		for(int current_dis=0; current_dis < distance; current_dis++)  //动态判断右移是否结束
		{
			for(int i=0;i<12;i++)   //判断活动积木右侧是否紧邻固定积木，若是则移动结束，否则继续
				for(int j=1;j<8;j++)
					if(this.panel.table[i][j] == Element.star && this.panel.table[i][j+1] == Element.X) //活动积木左侧有面板，移动结束
						break outer;

			for(int i=0;i<12;i++)  //若可继续右移，则对面板进行更新
				for(int j=6;j>=0;j--)
					if(this.panel.table[i][j] == Element.star)
					{
						this.panel.table[i][j] = Element.point;
						this.panel.table[i][j+1] = Element.star;
					};
		}

		Update();
		return new OpResult(ReturnCode.S001);
	}


	@Override
	public OpResult moveDown(int distance)
	{
		// 首先判断活动积木的行列索引
		// 再判断当前的旋转状态。

		int row = 0;      // 当前活动元素的左上角元素行列索引(row,column)
		int column = 0;
		int rotate_state;  //旋转次数 用于帮助判断积木在图中位置
		int is_break_loop =0;


		if(is_end == 1)  //判断当前是否已经游戏结束
			return new OpResult(ReturnCode.E005);
		if(is_active == 0)   // 判断当前是否还有可活动积木
			return new OpResult(ReturnCode.E007);

		//游戏未结束且有可活动积木时方可进行move left 操作
		//首先取出当前状态下积木的左上角的坐标
		for( row = 0; row< 12; row++)
		{
			for(column = 0; column<8; column++)
			{
				if (this.panel.table[row][column] == Element.star)
				{
					is_break_loop=1;
					break;
				}
			}
			if(is_break_loop == 1){
				break;
			}
		}
		//判断积木旋转次数
		rotate_state = judge_rotate_state(row,column);

		//根据积木标号和旋转次数，将积木位置在面板中标出
		if(current_building_block_order == 0)     //0号积木
			this.panel.table[row][column] = Element.star;

		if(current_building_block_order == 1)     //1号积木
		{
			if(rotate_state == 0 || rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
			};

			if(rotate_state == 1 || rotate_state == 3)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
			};

		};

		if(current_building_block_order == 2)     //2号积木
		{
			if(rotate_state == 0 || rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+2][column] = Element.star;
			};

			if(rotate_state == 1 || rotate_state == 3)      //3号积木
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row][column+2] = Element.star;
			};

		};

		if(current_building_block_order == 4)      //4号积木
		{
			if(rotate_state == 0)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row+1][column+1] = Element.star;
				this.panel.table[row+2][column+1] = Element.star;
			};

			if(rotate_state == 1)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+1][column-1] = Element.star;
				this.panel.table[row+1][column-2] = Element.star;
			};
			if(rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+2][column] = Element.star;
				this.panel.table[row+3][column] = Element.star;
			};
			if(rotate_state == 3)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row][column+2] = Element.star;
				this.panel.table[row+1][column] = Element.star;
			};

		};

		if(current_building_block_order == 5)      //5号积木
		{
			if(rotate_state == 0)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+2][column] = Element.star;
			};

			if(rotate_state == 1)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row][column+2] = Element.star;
				this.panel.table[row+1][column-2] = Element.star;
			};
			if(rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+2][column] = Element.star;
				this.panel.table[row+3][column] = Element.star;
			};
			if(rotate_state == 3)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row][column+2] = Element.star;
				this.panel.table[row+1][column] = Element.star;
			};

		};

		if(current_building_block_order == 6)      //6号积木
		{
			if(rotate_state == 0 || rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+1][column-1] = Element.star;
				this.panel.table[row+2][column-1] = Element.star;
			};

			if(rotate_state == 1 || rotate_state == 3)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row+1][column+1] = Element.star;
				this.panel.table[row+1][column+2] = Element.star;
			};

		};

		if(current_building_block_order == 7)     //7号积木
		{
			if(rotate_state == 0 || rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+1][column+1] = Element.star;
				this.panel.table[row+2][column+1] = Element.star;
			};

			if(rotate_state == 1 || rotate_state == 3)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+1][column-1] = Element.star;
			};

		};

		if(current_building_block_order == 8)     //8号积木
		{
			if(rotate_state == 0 || rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+2][column] = Element.star;
				this.panel.table[row+3][column] = Element.star;
			};

			if(rotate_state == 1 || rotate_state == 3)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row][column+2] = Element.star;
				this.panel.table[row][column+3] = Element.star;
			};

		};

		if(current_building_block_order == 5)      //9号积木
		{
			if(rotate_state == 0)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column-1] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+2][column] = Element.star;
			};

			if(rotate_state == 1)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column+1] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+1][column-1] = Element.star;
			};
			if(rotate_state == 2)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row+1][column] = Element.star;
				this.panel.table[row+1][column+1] = Element.star;
				this.panel.table[row+2][column] = Element.star;
			};
			if(rotate_state == 3)
			{
				this.panel.table[row][column] = Element.star;
				this.panel.table[row][column+1] = Element.star;
				this.panel.table[row][column+2] = Element.star;
				this.panel.table[row+1][column+1] = Element.star;
			};

		};

		if(current_building_block_order == 10)      //10号积木
		{
			this.panel.table[row][column] = Element.star;
		};

		int is_down = 0;
		outer:
		for(int current_dis=0; current_dis < distance; current_dis++)  //动态判断下移是否结束
		{
			for(int i=0;i<12;i++)   //判断活动积木下侧是否紧邻固定积木，若是则移动结束，否则继续
				for(int j=0;j<8;j++)
					if(this.panel.table[i][j] == Element.star && this.panel.table[i+1][j] == Element.X) //活动积木下侧有面板，移动结束，而且此时是在移动步数还未走完，再走则会变成固定积木
					{
						for(int ii=0;ii<12;ii++)
							for(int jj=0;jj<8;jj++)
								if(this.panel.table[ii][jj]==Element.star)
									this.panel.table[ii][jj] = Element.X;
						is_down = 1;
						break outer;
					}

			for(int i=10;i>=0;i--)  //若可继续下移，则对面板进行更新
				for(int j=0;j<8;j++)
					if(this.panel.table[i][j] == Element.star)
					{
						this.panel.table[i][j] = Element.point;
						this.panel.table[i+1][j] = Element.star;
					};
		}

		if(is_down == 1)  //如果活动积木在移动中已至底部，变为固定积木，则需考虑其是否存在满行消除
			for(int i=0;i<12;i++)
			{
				if(this.panel.table[i][0] == Element.X && this.panel.table[i][1] == Element.X && this.panel.table[i][2] == Element.X && this.panel.table[i][3] == Element.X && this.panel.table[i][4] == Element.X && this.panel.table[i][5] == Element.X && this.panel.table[i][6] == Element.X && this.panel.table[i][7] == Element.X)
				{
					for(int j=0;j<8;j++)
						this.panel.table[i][j] = Element.point;
					if(i==0);
					else
					{
						for(int ii=i;ii>0;ii--) //把满行以上的行下移
							for(int j=0;j<8;j++)
								this.panel.table[ii][j] = this.panel.table[ii-1][j];
					};
				}
			};


		Update();
		return new OpResult(ReturnCode.S001);

	}


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
						{
							if(this.panel.table[i + 1][j + 1] == Element.point ) {
								//旋转两次
								this.panel.table[i + 1][j] = Element.point;
								this.panel.table[i + 1][j + 1] = Element.star;
							}
						}
						else {                                //初始状态
							if (this.panel.table[i + 1][j + 1] == Element.point) {
								this.panel.table[i + 1][j] = Element.point;
								this.panel.table[i + 1][j + 1] = Element.star;
							}
						}
					}
					else    					//旋转3次状态
					{
						if(this.panel.table[i ][j + 1] == Element.point ) {
							this.panel.table[i][j + 1] = Element.star;
							this.panel.table[i + 1][j + 1] = Element.point;
						}
					}
				}
				else  							// 旋转一次状态
				{
					if(this.panel.table[i + 1][j] == Element.point ) {
						this.panel.table[i + 1][j] = Element.star;
						this.panel.table[i][j] = Element.point;
					}
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
					if(this.panel.table[i ][j - 1] == Element.point && this.panel.table[i + 2][j - 1] == Element.point ) {
						this.panel.table[i][j - 1] = Element.star;
						this.panel.table[i][j + 1] = Element.point;
						this.panel.table[i + 2][j - 1] = Element.point;
						this.panel.table[i + 2][j - 1] = Element.star;
					}
				}
			 else 
			 {								    //旋转1/3
				if(this.panel.table[i + 2][j] == Element.point && this.panel.table[i][j + 2] == Element.point) {
					this.panel.table[i + 2][j] = Element.star;
					this.panel.table[i][j] = Element.point;
					this.panel.table[i + 2][j + 2] = Element.point;
					this.panel.table[i][j + 2] = Element.star;
				}
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
					if(this.panel.table[i ][j +2] == Element.point) {
						this.panel.table[i + 2][j + 2] = Element.point; //rotate 3
						this.panel.table[i][j + 2] = Element.star;
					}
				 }
				 else
				 {
				 	if(this.panel.table[i + 2][j] == Element.point) {
						this.panel.table[i][j] = Element.point;   // rotate 1
						this.panel.table[i + 2][j] = Element.star;
					}
				 }
			 }
			 else if(this.panel.table[i+1][j-1] == Element.star)
			 {
			 	if(this.panel.table[i ][j - 1] == Element.point) {
					this.panel.table[i][j - 1] = Element.star;   // rotate 2
					this.panel.table[i][j + 1] = Element.point;
				}
			 }
			 else
			 {
			 	if(this.panel.table[i + 2][j + 2] == Element.point) {
					this.panel.table[i][j + 2] = Element.point;   // rotate 0
					this.panel.table[i + 2][j + 2] = Element.star;
				}
			 }

			 
		case 5: 	 
			 for(i=0; i< 12;i++)
		     {
				for(j=0; j<8; j++) 
				{
					if (this.panel.table[i][j] == Element.star)
					{
						is_break_loop[5] = 1;
						break;
					}
				}
				if(is_break_loop[5] == 1){
					break;
				}
		     }


			if( this.panel.table[i+1][j-1] == Element.star)
			{
				if(this.panel.table[i ][j - 1] == Element.point) {
					this.panel.table[i][j - 1] = Element.star;   // rotate 0
					this.panel.table[i][j + 1] = Element.point;
				}
			}
			else
			{
				if(this.panel.table[i+2][j] == Element.star && this.panel.table[i][j+2] == Element.star)
				{
					if(this.panel.table[i + 2][j + 2] == Element.point) {
						this.panel.table[i][j + 2] = Element.point;   // rotate 2
						this.panel.table[i + 2][j + 2] = Element.star;
					}
				}
				else if(this.panel.table[i][j+2] == Element.star && this.panel.table[i+2][j+2] == Element.star)
				{
					if(this.panel.table[i ][j + 2] == Element.point) {
						this.panel.table[i][j + 2] = Element.star;   // rotate 3
						this.panel.table[i][j] = Element.point;
					}
				}
				else if(this.panel.table[i+2][j] == Element.star && this.panel.table[i+2][j+2] == Element.star)
				{
					if(this.panel.table[i ][j + 2] == Element.point) {
						this.panel.table[i][j + 2] = Element.star;   // rotate 2
						this.panel.table[i + 2][j + 2] = Element.point;
					}
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
						is_break_loop[6] = 1;
						break;
					}
				}
				if(is_break_loop[6] == 1){
					break;
				}
		     }
			 if( this.panel.table[i+1][j] != Element.star)
			 {
			 	if(this.panel.table[i +1][j] == Element.point && this.panel.table[i + 1][j ] == Element.point){
				 this.panel.table[i][j] = Element.point;   // rotate 1
				 this.panel.table[i][j+1] = Element.point; 
				 this.panel.table[i+1][j] = Element.star;   // rotate 1
				 this.panel.table[i+1][j] = Element.star;
			 	}
			 }
			 else
			 {
				 if(this.panel.table[i][j+1] == Element.point)
				 {
				 	if(this.panel.table[i ][j] == Element.point && this.panel.table[i ][j + 1] == Element.point) {
						this.panel.table[i][j + 2] = Element.point;   // rotate 2
						this.panel.table[i + 1][j + 2] = Element.point;
						this.panel.table[i][j] = Element.star;   // rotate 2
						this.panel.table[i][j + 1] = Element.star;
					}
				 }
				 else if(this.panel.table[i+2][j+2] == Element.star)
				 {
				 	if(this.panel.table[i ][j + 2] == Element.point&& this.panel.table[i + 1][j + 2] == Element.point) {
						this.panel.table[i + 2][j + 2] = Element.point;   // rotate 3
						this.panel.table[i + 1][j + 2] = Element.point;
						this.panel.table[i][j + 2] = Element.star;   // rotate 3
						this.panel.table[i + 1][j + 2] = Element.star;
					}
				 }
				 else
				 {
				 	if(this.panel.table[i + 2][j + 1] == Element.point  && this.panel.table[i + 2][j + 2] == Element.point) {
						this.panel.table[i + 1][j] = Element.point;   // rotate 0
						this.panel.table[i + 2][j] = Element.point;
						this.panel.table[i + 2][j + 1] = Element.star;   // rotate 0
						this.panel.table[i + 2][j + 2] = Element.star;
					}
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
						is_break_loop[7] = 1;
						break;
					}
				}
				if(is_break_loop[7] == 1){
					break;
				}
		     }
			 if( this.panel.table[i+2][j-1] != Element.star)
			 {
			 	if(this.panel.table[i ][j ] == Element.point && this.panel.table[i + 1][j ] == Element.point) {
					this.panel.table[i][j] = Element.star;
					this.panel.table[i + 1][j] = Element.star;
					this.panel.table[i][j + 1] = Element.point;   // rotate 0
					this.panel.table[i][j + 2] = Element.point;
				}
			 }
			 else
			 {
				 if(this.panel.table[i][j+1] == Element.point)
				 {
				 	if(this.panel.table[i ][j + 1] == Element.point && this.panel.table[i ][j + 2] == Element.point) {
						this.panel.table[i][j + 1] = Element.star;   // rotate 1
						this.panel.table[i][j + 2] = Element.star;
						this.panel.table[i + 1][j + 2] = Element.point;
						this.panel.table[i + 2][j + 2] = Element.point;
					}
				 }
				 else if(this.panel.table[i+2][j+2] == Element.star)
				 {
				 	if(this.panel.table[i ][j] == Element.point && this.panel.table[i + 1][j ] == Element.point) {
						this.panel.table[i + 2][j] = Element.point;   // rotate 3
						this.panel.table[i + 2][j + 1] = Element.point;
						this.panel.table[i][j] = Element.star;
						this.panel.table[i + 1][j] = Element.star;
					}
				 }
				 else
				 {
				 	if(this.panel.table[i + 1][j + 2] == Element.point && this.panel.table[i + 2][j + 2] == Element.point){
					 this.panel.table[i+2][j] = Element.point;   
					 this.panel.table[i+2][j+1] = Element.point;
					 this.panel.table[i+1][j+2] = Element.star;   // rotate 2
					 this.panel.table[i+2][j+2] = Element.star;
				     }
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
						is_break_loop[8] = 1;
						break;
					}
				}
				if(is_break_loop[8] == 1){
					break;
				}
		     }
			 
			 if( this.panel.table[i+1][j-1] == Element.point)
			 {
			 	if(this.panel.table[i ][j ] == Element.point && this.panel.table[i + 2][j + 2] == Element.point && this.panel.table[i + 2][j + 3] == Element.point && this.panel.table[i + 3][j +2 ] == Element.point && this.panel.table[i + 3][j + 3] == Element.point ) {
					this.panel.table[i][j] = Element.star;
					this.panel.table[i + 2][j + 2] = Element.star;
					this.panel.table[i + 2][j + 3] = Element.star;
					this.panel.table[i + 3][j + 2] = Element.star;
					this.panel.table[i + 3][j + 3] = Element.star;
					this.panel.table[i + 2][j] = Element.point;   // rotate 0
					this.panel.table[i + 3][j] = Element.point;
					this.panel.table[i][j + 3] = Element.point;
					this.panel.table[i + 3][j + 1] = Element.point;
					this.panel.table[i + 2][j + 1] = Element.point;
				}
			 }
			 else if(this.panel.table[i+3][j] == Element.star) {
				 if (this.panel.table[i][j - 1] == Element.point && this.panel.table[i][j - 2] == Element.point && this.panel.table[i + 1][j - 1] == Element.point && this.panel.table[i + 1][j + 2] == Element.point && this.panel.table[i + 3][j + 1] == Element.point) {

					 this.panel.table[i][j - 1] = Element.star;
					 this.panel.table[i][j - 2] = Element.star;
					 this.panel.table[i + 1][j - 1] = Element.star;
					 this.panel.table[i + 1][j + 2] = Element.star;
					 this.panel.table[i + 3][j + 1] = Element.star;
					 this.panel.table[i][j] = Element.point;   // rotate 2
					 this.panel.table[i + 1][j] = Element.point;
					 this.panel.table[i][j + 1] = Element.point;
					 this.panel.table[i + 1][j + 1] = Element.point;
					 this.panel.table[i + 3][j - 2] = Element.point;
				 }
			 }
			 else if(this.panel.table[i+2][j] == Element.star)
			 {
				 if(this.panel.table[i ][j ] == Element.point && this.panel.table[i + 2][j + 2] == Element.point && this.panel.table[i + 2][j + 3] == Element.point && this.panel.table[i + 3][j +2 ] == Element.point && this.panel.table[i + 3][j + 3] == Element.point ) {

					 this.panel.table[i][j] = Element.point;
					 this.panel.table[i + 2][j + 2] = Element.point;
					 this.panel.table[i + 2][j + 3] = Element.point;
					 this.panel.table[i + 3][j + 2] = Element.point;
					 this.panel.table[i + 3][j + 3] = Element.point;
					 this.panel.table[i + 3][j] = Element.star;   // rotate 3
					 this.panel.table[i][j + 2] = Element.star;
					 this.panel.table[i][j + 3] = Element.star;
					 this.panel.table[i + 1][j + 2] = Element.star;
					 this.panel.table[i + 1][j + 3] = Element.star;
				 }
			 }
			 else
			 {
				 if(this.panel.table[i + 2][j ] == Element.point && this.panel.table[i + 3][j] == Element.point && this.panel.table[i + 2][j + 1] == Element.point && this.panel.table[i + 3][j +1 ] == Element.point && this.panel.table[i][j + 3] == Element.point ) {

					 this.panel.table[i][j] = Element.point;
					 this.panel.table[i + 1][j ] = Element.point;
					 this.panel.table[i ][j + 1] = Element.point;
					 this.panel.table[i + 1][j + 1] = Element.point;
					 this.panel.table[i + 3][j + 3] = Element.point;
					 this.panel.table[i + 2][j] = Element.star;   // rotate 1
					 this.panel.table[i + 3][j] = Element.star;
					 this.panel.table[i + 2][j + 1] = Element.star;
					 this.panel.table[i + 3][j + 1] = Element.star;
					 this.panel.table[i ][j + 3] = Element.star;
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
						is_break_loop[9] = 1;
						break;
					}
				}
				if(is_break_loop[9] == 1){
					break;
				}
		     }
			 
			 if(this.panel.table[i+2][j+2] == Element.star && this.panel.table[i+2][j] == Element.star)
			 {
			 	if(this.panel.table[i][j+2] == Element.point){
				 this.panel.table[i + 2][j + 2] = Element.point; //rotate 3
				 this.panel.table[i][j + 2] = Element.star;
			 	}
			 }
			 else if(this.panel.table[i+2][j+2] == Element.star)
			 {
				 if(this.panel.table[i + 2][j] == Element.point){
				 this.panel.table[i][j] = Element.point;   // rotate 1
				 this.panel.table[i + 2][j] = Element.star;
				 }
			 }
			 else if(this.panel.table[i+1][j-1] == Element.star)
	         {
				 if(this.panel.table[i][j - 1] == Element.point){
				 this.panel.table[i][j - 1] = Element.star;   // rotate 2
				 this.panel.table[i][j + 1] = Element.point;
				 }
	         }
			 else
			{
				if(this.panel.table[i+2][j+2] == Element.point){
				this.panel.table[i][j + 2] = Element.point;   // rotate 0
				this.panel.table[i + 2][j + 2] = Element.star;
			    }
			 }
			 break;
			 
		case 10: 	break;
		}	
		return new OpResult(ReturnCode.E001);
	}

	/*
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

	/*
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

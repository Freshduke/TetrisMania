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

	private int sys_time = 0;
	private int rotate_state=0;
	private int[] queue=new int[10];
	private int current_building_block_order;
	public MyPanel panel;
	private int is_active;                      //当前是否有活动积木,0表示当前panel内务活动积木
	private int is_end = 0;                         //当前游戏结束条件，
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
		this.panel=new MyPanel();
		this.sys_time = 0;
		rotate_state=0;
		is_active=0;                      //当前是否有活动积木,0表示当前panel内务活动积木
		is_end = 0; 
		for(int i=0; i< 10;i++) {
			this.queue[i] = 66;  // 66 means that the position in queue is empty.
		}
		this.current_building_block_order = 66;
	}

	public void Update () {
		this.rotate_state=0;
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
						if(this.panel.table[0][3] == Element.point  && this.panel.table[1][3] == Element.point){
							is_active = 1;
							this.panel.table[0][3] = Element.star;
							this.panel.table[1][3] = Element.star;
						}
						else
						{
							is_end = 1;
						}
						break;
					case 2:
						if(this.panel.table[0][3] == Element.point   && this.panel.table[1][3] == Element.point  && this.panel.table[2][3] == Element.point )
						{
							this.panel.table[0][3] = Element.star;
							this.panel.table[1][3] = Element.star;
							this.panel.table[2][3] = Element.star;
							is_active = 1;
						}
						else{
							is_end = 1;
						}
						break;
					case 3:
						if(this.panel.table[0][3] == Element.point && this.panel.table[1][3] == Element.point && this.panel.table[0][4] == Element.point ){
							this.panel.table[0][3] = Element.star;
							this.panel.table[0][4] = Element.star;
							this.panel.table[1][3] = Element.star;
							is_active = 1;
						}
						else{
							is_end = 1;
						}
						break;
					case 4:
						if(this.panel.table[0][3] == Element.point && this.panel.table[0][4] == Element.point && this.panel.table[1][4] == Element.point && this.panel.table[2][4] == Element.point )
						{
							this.panel.table[0][3] = Element.star;
							this.panel.table[0][4] = Element.star;
							this.panel.table[1][4] = Element.star;
							this.panel.table[2][4] = Element.star;
							is_active = 1;
						}
						else{
							is_end = 1;
						}
						break;
					case 5:
						if(this.panel.table[0][3] == Element.point && this.panel.table[0][4] == Element.point && this.panel.table[1][3] == Element.point && this.panel.table[2][3] == Element.point ) {
							this.panel.table[0][3] = Element.star;
							this.panel.table[0][4] = Element.star;
							this.panel.table[1][3] = Element.star;
							this.panel.table[2][3] = Element.star;
							is_active = 1;
						}
						else{
							is_end = 1;
						}
						break;
					case 6:
						if(this.panel.table[0][4] == Element.point && this.panel.table[1][4] == Element.point && this.panel.table[1][3] == Element.point && this.panel.table[2][3] == Element.point  ) {
							this.panel.table[0][4] = Element.star;
							this.panel.table[1][3] = Element.star;
							this.panel.table[1][4] = Element.star;
							this.panel.table[2][3] = Element.star;
							is_active = 1;
						}
						else{
							is_end = 1;
						}
						break;
					case 7:
						if(this.panel.table[0][3] == Element.point && this.panel.table[1][3] == Element.point && this.panel.table[1][4] == Element.point && this.panel.table[1][4] == Element.point && this.panel.table[2][4] == Element.point ) {
							this.panel.table[0][3] = Element.star;
							this.panel.table[1][3] = Element.star;
							this.panel.table[1][4] = Element.star;
							this.panel.table[2][4] = Element.star;
							is_active = 1;
						}
						else{
							is_end = 1;
						}
						break;
					case 8:
						if(this.panel.table[0][3] == Element.point && this.panel.table[1][3] == Element.point && this.panel.table[2][3] == Element.point && this.panel.table[3][3] == Element.point) {
							this.panel.table[0][3] = Element.star;
							this.panel.table[1][3] = Element.star;
							this.panel.table[2][3] = Element.star;
							this.panel.table[3][3] = Element.star;
							is_active = 1;
						}
						else{
							is_end = 1;
						}
						break;

					case 9:
						if(this.panel.table[0][4] == Element.point && this.panel.table[1][3] == Element.point && this.panel.table[1][4] == Element.point && this.panel.table[2][4] == Element.point ) {
							this.panel.table[0][4] = Element.star;
							this.panel.table[1][3] = Element.star;
							this.panel.table[1][4] = Element.star;
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
		this.is_active = 0; 
		this.panel=new MyPanel();
		this.sys_time = 0;
		rotate_state=0;
		is_active=0;                      //当前是否有活动积木,0表示当前panel内务活动积木
		is_end = 0; 
		for(int i=0; i< 10;i++) {
			this.queue[i] = 66;  // 66 means that the position in queue is empty.
		}
		this.current_building_block_order = 66;
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
		if(is_end == 1){
			System.out.println("E005");
			return new OpResult(ReturnCode.E005);

		}
		else {
			int i = 0;
			int j = 0;
			int length = ids.length;
			int free_pointer = 0;   //检测queue 第一个 66的位置，记录在free_location.
			int free_location = 0;

			for (i = 0; i < 10; i++) {
				if (queue[i] == 66) {
					free_location = 9 - i;
					free_pointer = i;
					break;
				}
			}
			if (length > free_location) {
				System.out.println("E006");
				return new OpResult(ReturnCode.E006);
			} else {
				for (int k = free_pointer; k < 10; k++) {
					queue[k] = ids[j];
					j++;
					if (j == length) {
						break;
					}
				}
				if(this.is_active==0){
					Update();
				}
				System.out.println("S001");
				return new OpResult(ReturnCode.S001);
			}
			//return new OpResult(ReturnCode.E001);
		}
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
		if(this.is_active==0){
			Update();
		}
		int row = 0;      // 当前活动元素的左上角元素行列索引(row,column)
		int column = 0;
		int is_break_loop =0;


		if(is_end == 1){  //判断当前是否已经游戏结束
			System.out.println("Game Over!");
			return new OpResult(ReturnCode.E005);
		}
		if(is_active == 0){   // 判断当前是否还有可活动积木
			System.out.println("ERROR:No Active blocks!");
			return new OpResult(ReturnCode.E007);
		}
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
		for(int current_dis=0; current_dis < distance; current_dis++)  //动态判断左移是否结束
		{
			for(int i=0;i<12;i++)  //判断积木是否到达面板最左端
			   if(this.panel.table[i][0] == Element.star)
				   break outer;
			
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
		System.out.println("move left succeed!");

		return new OpResult(ReturnCode.S001);
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
	 */
	@Override
	public OpResult moveRight(int distance)
	{
		// 首先判断活动积木的行列索引
		// 再判断当前的旋转状态。
		if(this.is_active==0){
			Update();
		}
		int row = 0;      // 当前活动元素的左上角元素行列索引(row,column)
		int column = 0;
		int is_break_loop =0;


		if(is_end == 1){  //判断当前是否已经游戏结束
			System.out.println("Game Over!");
			return new OpResult(ReturnCode.E005);
		}
		if(is_active == 0){   // 判断当前是否还有可活动积木
			System.out.println("ERROR:No Active blocks!");
			return new OpResult(ReturnCode.E007);
		}
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
			for(int i=0;i<12;i++)  //判断积木是否到达面板最右端
				   if(this.panel.table[i][7] == Element.star)
					   break outer;
			
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

		System.out.println("move right suceed!");
		return new OpResult(ReturnCode.S001);
	}


	@Override
	public OpResult moveDown(int distance)
	{
		// 首先判断活动积木的行列索引
		// 再判断当前的旋转状态。

		int row = 0;      // 当前活动元素的左上角元素行列索引(row,column)
		int column = 0;
		int is_break_loop =0;


		if(is_end == 1){  //判断当前是否已经游戏结束
			System.out.println("Game Over!");
			return new OpResult(ReturnCode.E005);
		}
		if(is_active == 0){   // 判断当前是否还有可活动积木
			System.out.println("ERROR:No Active blocks!");
			return new OpResult(ReturnCode.E007);
		}
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

		int is_down = 0;
		outer:
		for(int current_dis=0; current_dis < distance; current_dis++)  //动态判断下移是否结束
		{
			for(int i=0;i<12;i++)   //判断活动积木下侧是否紧邻固定积木，若是则移动结束，否则继续
				for(int j=0;j<8;j++)
				 {
					if(i == 11)   //首先判断积木是否到达最底部
						for(int k=0;k<8;k++)
							if(this.panel.table[11][k] == Element.star)  //如果积木到达最底部，则下一步必然会使其变成固定积木，因此在这里提前判断
								{
									for(int ii=0;ii<12;ii++)
										for(int jj=0;jj<8;jj++)
											if(this.panel.table[ii][jj]==Element.star)
												this.panel.table[ii][jj] = Element.X;
									is_down = 1;
									is_active = 0;
									break outer;
								};
					
					if(this.panel.table[i][j] == Element.star && (this.panel.table[i+1][j] == Element.X )) //活动积木下侧有面板，移动结束，而且此时是在移动步数还未走完，再走则会变成固定积木
					{
						for(int ii=0;ii<12;ii++)
							for(int jj=0;jj<8;jj++)
								if(this.panel.table[ii][jj]==Element.star)
									this.panel.table[ii][jj] = Element.X;
						is_down = 1;
						is_active = 0;
						break outer;   
					};
				 };
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

		System.out.println("move down suceed!");
		return new OpResult(ReturnCode.S001);


	}
	
	private void update_rotate_state(){
		this.rotate_state++;
		if(this.rotate_state==4){
			this.rotate_state=0;
		}
	}

	@Override
	public OpResult rotate()
	{
		if(this.is_end==1){
			System.out.println("ERROR: Game Over!");
			return new OpResult(ReturnCode.E005);
		}
		if(this.is_active==0){
			System.out.println("ERROR: No Active Blocks!");
			return new OpResult(ReturnCode.E007);
		}
		int row_start=0;
		int coloumn_start=0;
		boolean flag=false;
		for(row_start=0;row_start<12;row_start++){
			for(coloumn_start=0;coloumn_start<8;coloumn_start++){
				if(this.panel.table[row_start][coloumn_start]==Element.star){
					System.out.println(row_start+" "+coloumn_start);
					flag=true;
					break;
				}
			}
			if(flag==true){
				break;
			}
		}
		
		switch(current_building_block_order){
		case 0:System.out.println("Rotate Once!");	break;
		case 1:if(this.rotate_state==0){
					if(coloumn_start+1<8){
							if(this.panel.table[row_start][coloumn_start+1]==Element.point){
								update_rotate_state();	
								this.panel.table[row_start+1][coloumn_start]=Element.point;
								this.panel.table[row_start][coloumn_start+1]=Element.star;
							}
					}
				}else if(this.rotate_state==1){
					if(row_start+1<12){
							if(this.panel.table[row_start+1][coloumn_start+1]==Element.point){
								update_rotate_state();	
								this.panel.table[row_start][coloumn_start]=Element.point;
								this.panel.table[row_start+1][coloumn_start+1]=Element.star;
							}
					 }
				}else if(this.rotate_state==2){
					if(coloumn_start-1>=0){
							if(this.panel.table[row_start+1][coloumn_start-1]==Element.point){
								update_rotate_state();	
								this.panel.table[row_start][coloumn_start]=Element.point;
								this.panel.table[row_start+1][coloumn_start-1]=Element.star;
							}
					 }
				}else if(this.rotate_state==3){
					if(this.panel.table[row_start-1][coloumn_start]==Element.point){
							update_rotate_state();	
							this.panel.table[row_start][coloumn_start+1]=Element.point;
							this.panel.table[row_start-1][coloumn_start]=Element.star;
					 }
				}
			   break;
		case 2:if(this.rotate_state==0){
					if((coloumn_start+1<8)&&(coloumn_start-1>=0)){
								if((this.panel.table[row_start+1][coloumn_start-1]==Element.point)&&(this.panel.table[row_start+2][coloumn_start-1]==Element.point)&&(this.panel.table[row_start][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+1]==Element.point)){
									update_rotate_state();	
									this.panel.table[row_start][coloumn_start]=Element.point;
									this.panel.table[row_start+2][coloumn_start]=Element.point;
									this.panel.table[row_start+1][coloumn_start-1]=Element.star;
									this.panel.table[row_start+1][coloumn_start+1]=Element.star;
								}
					}
				}else if(this.rotate_state==1){
					if(row_start+1<12){
								if((this.panel.table[row_start-1][coloumn_start]==Element.point)&&(this.panel.table[row_start-1][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+2]==Element.point)){
									update_rotate_state();	
									this.panel.table[row_start][coloumn_start]=Element.point;
									this.panel.table[row_start][coloumn_start+2]=Element.point;
									this.panel.table[row_start-1][coloumn_start+1]=Element.star;
									this.panel.table[row_start+1][coloumn_start+1]=Element.star;
								}
					}
				}else if(this.rotate_state==2){
					if((coloumn_start+1<8)&&(coloumn_start-1>=0)){
						if((this.panel.table[row_start+1][coloumn_start-1]==Element.point)&&(this.panel.table[row_start+2][coloumn_start-1]==Element.point)&&(this.panel.table[row_start][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+1]==Element.point)){
							update_rotate_state();
							this.panel.table[row_start][coloumn_start]=Element.point;
							this.panel.table[row_start+2][coloumn_start]=Element.point;
							this.panel.table[row_start+1][coloumn_start-1]=Element.star;
							this.panel.table[row_start+1][coloumn_start+1]=Element.star;
						}
					}
				}else if(this.rotate_state==3){
					if(row_start+1<12){
						if((this.panel.table[row_start-1][coloumn_start]==Element.point)&&(this.panel.table[row_start-1][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+2]==Element.point)){
							update_rotate_state();
							this.panel.table[row_start][coloumn_start]=Element.point;
							this.panel.table[row_start][coloumn_start+2]=Element.point;
							this.panel.table[row_start-1][coloumn_start+1]=Element.star;
							this.panel.table[row_start+1][coloumn_start+1]=Element.star;
						}
					}
				}
				break;
		case 3:if(this.rotate_state==0){
			if(this.panel.table[row_start+1][coloumn_start+1]==Element.point){
					update_rotate_state();
					this.panel.table[row_start+1][coloumn_start]=Element.point;
					this.panel.table[row_start+1][coloumn_start+1]=Element.star;
				}
			}else if(this.rotate_state==1){
				if(this.panel.table[row_start+1][coloumn_start]==Element.point){
					update_rotate_state();	
					this.panel.table[row_start][coloumn_start]=Element.point;
					this.panel.table[row_start+1][coloumn_start]=Element.star;
				}
			}else if(this.rotate_state==2){
				if(this.panel.table[row_start][coloumn_start-1]==Element.point){
					update_rotate_state();	
					this.panel.table[row_start][coloumn_start]=Element.point;
					this.panel.table[row_start][coloumn_start-1]=Element.star;
				}
			}else if(this.rotate_state==3){
				if(this.panel.table[row_start][coloumn_start+1]==Element.point){
					update_rotate_state();	
					this.panel.table[row_start+1][coloumn_start+1]=Element.point;
					this.panel.table[row_start][coloumn_start+1]=Element.star;
				}
			}
			break;
		case 4:if(this.rotate_state==0){
				if(coloumn_start+1<8){
					if((this.panel.table[row_start+1][coloumn_start]==Element.point)&&(this.panel.table[row_start+2][coloumn_start]==Element.point)&&(this.panel.table[row_start][coloumn_start+2]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+2]==Element.point)){
						update_rotate_state();
						this.panel.table[row_start][coloumn_start]=Element.point;
						this.panel.table[row_start][coloumn_start+1]=Element.point;
						this.panel.table[row_start+2][coloumn_start+1]=Element.point;
						this.panel.table[row_start][coloumn_start+2]=Element.star;
						this.panel.table[row_start+1][coloumn_start+2]=Element.star;
						this.panel.table[row_start+1][coloumn_start]=Element.star;
					}
				 }
				}else if(this.rotate_state==1){
					if(row_start+1<12){
						if((this.panel.table[row_start][coloumn_start-2]==Element.point)&&(this.panel.table[row_start][coloumn_start-1]==Element.point)&&(this.panel.table[row_start+2][coloumn_start-1]==Element.point)&&(this.panel.table[row_start+2][coloumn_start]==Element.point)){
							update_rotate_state();
							this.panel.table[row_start][coloumn_start]=Element.point;
							this.panel.table[row_start+1][coloumn_start]=Element.point;
							this.panel.table[row_start+1][coloumn_start-2]=Element.point;
							this.panel.table[row_start][coloumn_start-1]=Element.star;
							this.panel.table[row_start+2][coloumn_start-1]=Element.star;
							this.panel.table[row_start+2][coloumn_start]=Element.star;
						}
					}
				}else if(this.rotate_state==2){
					if(coloumn_start-1>=0){
						if((this.panel.table[row_start+1][coloumn_start-1]==Element.point)&&(this.panel.table[row_start+2][coloumn_start-1]==Element.point)&&(this.panel.table[row_start][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+1]==Element.point)){
							update_rotate_state();
							this.panel.table[row_start][coloumn_start]=Element.point;
							this.panel.table[row_start+2][coloumn_start]=Element.point;
							this.panel.table[row_start+2][coloumn_start+1]=Element.point;
							this.panel.table[row_start+1][coloumn_start-1]=Element.star;
							this.panel.table[row_start+2][coloumn_start-1]=Element.star;
							this.panel.table[row_start+1][coloumn_start+1]=Element.star;
						}
					}
				}
				else if(this.rotate_state==3){
					if((this.panel.table[row_start-1][coloumn_start]==Element.point)&&(this.panel.table[row_start-1][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+2]==Element.point)){
						update_rotate_state();
						this.panel.table[row_start][coloumn_start]=Element.point;
						this.panel.table[row_start+1][coloumn_start]=Element.point;
						this.panel.table[row_start][coloumn_start+2]=Element.point;
						this.panel.table[row_start-1][coloumn_start]=Element.star;
						this.panel.table[row_start-1][coloumn_start+1]=Element.star;
						this.panel.table[row_start+1][coloumn_start+1]=Element.star;
					}
				}
				break;
		case 5:if(this.rotate_state==0){
					if(coloumn_start-1>=0){
						if((this.panel.table[row_start+1][coloumn_start-1]==Element.point)&&(this.panel.table[row_start+2][coloumn_start-1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+2][coloumn_start+1]==Element.point)){
							update_rotate_state();
							this.panel.table[row_start][coloumn_start]=Element.point;
							this.panel.table[row_start][coloumn_start+1]=Element.point;
							this.panel.table[row_start+2][coloumn_start]=Element.point;
							this.panel.table[row_start+1][coloumn_start-1]=Element.star;
							this.panel.table[row_start+1][coloumn_start+1]=Element.star;
							this.panel.table[row_start+2][coloumn_start+1]=Element.star;
						}
					}
				}else if(this.rotate_state==1){
					if((this.panel.table[row_start-1][coloumn_start]==Element.point)&&(this.panel.table[row_start-1][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+1]==Element.point)){
						update_rotate_state();
						this.panel.table[row_start][coloumn_start]=Element.point;
						this.panel.table[row_start][coloumn_start+2]=Element.point;
						this.panel.table[row_start+1][coloumn_start+2]=Element.point;
						this.panel.table[row_start-1][coloumn_start+1]=Element.star;
						this.panel.table[row_start+1][coloumn_start]=Element.star;
						this.panel.table[row_start+1][coloumn_start+1]=Element.star;
					}
				}else if(this.rotate_state==2){
					if(coloumn_start+1<8){
						if((this.panel.table[row_start][coloumn_start-1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start-1]==Element.point)&&(this.panel.table[row_start][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+1]==Element.point)){
							update_rotate_state();
							this.panel.table[row_start][coloumn_start]=Element.point;
							this.panel.table[row_start+2][coloumn_start-1]=Element.point;
							this.panel.table[row_start+2][coloumn_start]=Element.point;
							this.panel.table[row_start][coloumn_start-1]=Element.star;
							this.panel.table[row_start+1][coloumn_start-1]=Element.star;
							this.panel.table[row_start+1][coloumn_start+1]=Element.star;
						}
					}
				}else if(this.rotate_state==3){
					if(row_start+1<12){
						if((this.panel.table[row_start][coloumn_start+1]==Element.point)&&(this.panel.table[row_start][coloumn_start+2]==Element.point)&&(this.panel.table[row_start+2][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+2][coloumn_start+2]==Element.point)){
							update_rotate_state();
							this.panel.table[row_start][coloumn_start]=Element.point;
							this.panel.table[row_start+1][coloumn_start]=Element.point;
							this.panel.table[row_start+1][coloumn_start+2]=Element.point;
							this.panel.table[row_start][coloumn_start+1]=Element.star;
							this.panel.table[row_start][coloumn_start+2]=Element.star;
							this.panel.table[row_start+2][coloumn_start+1]=Element.star;
						}
					}
				}
				break;
		case 6:if(this.rotate_state==0){
				if(coloumn_start+1<8){
					if((this.panel.table[row_start][coloumn_start-1]==Element.point)&&(this.panel.table[row_start][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+1]==Element.point)){
						update_rotate_state();
						this.panel.table[row_start+1][coloumn_start-1]=Element.point;
						this.panel.table[row_start+2][coloumn_start-1]=Element.point;
						this.panel.table[row_start][coloumn_start-1]=Element.star;
						this.panel.table[row_start+1][coloumn_start+1]=Element.star;
					}
				}
			}else if(this.rotate_state==1){
				if(row_start+1<12){
					if((this.panel.table[row_start][coloumn_start+2]==Element.point)&&(this.panel.table[row_start+2][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+2][coloumn_start+2]==Element.point)){
						update_rotate_state();
						this.panel.table[row_start][coloumn_start]=Element.point;
						this.panel.table[row_start][coloumn_start+1]=Element.point;
						this.panel.table[row_start][coloumn_start+2]=Element.star;
						this.panel.table[row_start+2][coloumn_start+1]=Element.star;
					}
				}
			}else if(this.rotate_state==2){
				if(coloumn_start-1>=0){
					if((this.panel.table[row_start+1][coloumn_start-2]==Element.point)&&(this.panel.table[row_start+2][coloumn_start-2]==Element.point)&&(this.panel.table[row_start+2][coloumn_start]==Element.point)){
						update_rotate_state();
						this.panel.table[row_start][coloumn_start]=Element.point;
						this.panel.table[row_start+1][coloumn_start]=Element.point;
						this.panel.table[row_start+1][coloumn_start-2]=Element.star;
						this.panel.table[row_start+2][coloumn_start]=Element.star;
					}
				}
			}else if(this.rotate_state==3){
				if(coloumn_start-1>=0){
					if((this.panel.table[row_start-1][coloumn_start]==Element.point)&&(this.panel.table[row_start-1][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start]==Element.point)){
						update_rotate_state();
						this.panel.table[row_start+1][coloumn_start+1]=Element.point;
						this.panel.table[row_start+1][coloumn_start+2]=Element.point;
						this.panel.table[row_start-1][coloumn_start+1]=Element.star;
						this.panel.table[row_start+1][coloumn_start]=Element.star;
					}
				}
			}
			break;
		case 7:if(this.rotate_state==0){
				if(coloumn_start-1>=0){
					if((this.panel.table[row_start][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+2][coloumn_start-1]==Element.point)&&(this.panel.table[row_start+2][coloumn_start]==Element.point)){
						update_rotate_state();
						this.panel.table[row_start][coloumn_start]=Element.point;
						this.panel.table[row_start+2][coloumn_start+1]=Element.point;
						this.panel.table[row_start+2][coloumn_start-1]=Element.star;
						this.panel.table[row_start+2][coloumn_start]=Element.star;
					}
				}
			}else if(this.rotate_state==1){
				if((this.panel.table[row_start-1][coloumn_start-1]==Element.point)&&(this.panel.table[row_start][coloumn_start-1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+1]==Element.point)){
					update_rotate_state();
					this.panel.table[row_start+1][coloumn_start-1]=Element.point;
					this.panel.table[row_start][coloumn_start+1]=Element.point;
					this.panel.table[row_start][coloumn_start-1]=Element.star;
					this.panel.table[row_start-1][coloumn_start-1]=Element.star;
				}
			}else if(this.rotate_state==2){
				if(coloumn_start+2<8){
					if((this.panel.table[row_start][coloumn_start+1]==Element.point)&&(this.panel.table[row_start][coloumn_start+2]==Element.point)&&(this.panel.table[row_start+2][coloumn_start]==Element.point)){
						update_rotate_state();
						this.panel.table[row_start][coloumn_start]=Element.point;
						this.panel.table[row_start+2][coloumn_start+1]=Element.point;
						this.panel.table[row_start][coloumn_start+1]=Element.star;
						this.panel.table[row_start][coloumn_start+2]=Element.star;
					}
				}
			}else if(this.rotate_state==3){
				if(row_start+1<12){
					if((this.panel.table[row_start][coloumn_start-1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+2][coloumn_start+1]==Element.point)){
						update_rotate_state();
						this.panel.table[row_start+1][coloumn_start-1]=Element.point;
						this.panel.table[row_start][coloumn_start+1]=Element.point;
						this.panel.table[row_start+2][coloumn_start+1]=Element.star;
						this.panel.table[row_start+1][coloumn_start+1]=Element.star;
					}
				}
			}
			break;
		case 8:if(this.rotate_state==0){
				if((coloumn_start-1>=0)&&(coloumn_start+2<8)){
					if((this.panel.table[row_start+1][coloumn_start-1]==Element.point)&&(this.panel.table[row_start+2][coloumn_start-1]==Element.point)&&(this.panel.table[row_start+3][coloumn_start-1]==Element.point)&&(this.panel.table[row_start][coloumn_start+1]==Element.point)&&(this.panel.table[row_start][coloumn_start+2]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+2]==Element.point)){
						update_rotate_state();
						this.panel.table[row_start][coloumn_start]=Element.point;
						this.panel.table[row_start+2][coloumn_start]=Element.point;
						this.panel.table[row_start+3][coloumn_start]=Element.point;
						this.panel.table[row_start+1][coloumn_start-1]=Element.star;
						this.panel.table[row_start+1][coloumn_start+1]=Element.star;
						this.panel.table[row_start+1][coloumn_start+2]=Element.star;
					}
				}
			}else if(this.rotate_state==1){
				if(row_start+2<12){
					if((this.panel.table[row_start-1][coloumn_start]==Element.point)&&(this.panel.table[row_start-1][coloumn_start+1]==Element.point)&&(this.panel.table[row_start-1][coloumn_start+2]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+2]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+3]==Element.point)&&(this.panel.table[row_start+2][coloumn_start+2]==Element.point)&&(this.panel.table[row_start+2][coloumn_start+3]==Element.point)){
						update_rotate_state();
						this.panel.table[row_start][coloumn_start]=Element.point;
						this.panel.table[row_start][coloumn_start+1]=Element.point;
						this.panel.table[row_start][coloumn_start+3]=Element.point;
						this.panel.table[row_start-1][coloumn_start+2]=Element.star;
						this.panel.table[row_start+1][coloumn_start+2]=Element.star;
						this.panel.table[row_start+2][coloumn_start+2]=Element.star;
					}
				}
			}else if(this.rotate_state==2){
				if((coloumn_start-2>=0)&&(coloumn_start+1<8)){
					if((this.panel.table[row_start][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+2][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+2][coloumn_start-2]==Element.point)&&(this.panel.table[row_start+2][coloumn_start-1]==Element.point)&&(this.panel.table[row_start+3][coloumn_start-2]==Element.point)&&(this.panel.table[row_start+3][coloumn_start-1]==Element.point)){
						update_rotate_state();
						this.panel.table[row_start][coloumn_start]=Element.point;
						this.panel.table[row_start+1][coloumn_start]=Element.point;
						this.panel.table[row_start+3][coloumn_start]=Element.point;
						this.panel.table[row_start+2][coloumn_start-1]=Element.star;
						this.panel.table[row_start+2][coloumn_start+1]=Element.star;
						this.panel.table[row_start+2][coloumn_start-2]=Element.star;
					}
				}
			}else if(this.rotate_state==3){
				if(row_start+1<12){
					if((this.panel.table[row_start+1][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+2]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+3]==Element.point)&&(this.panel.table[row_start-2][coloumn_start]==Element.point)&&(this.panel.table[row_start-2][coloumn_start+1]==Element.point)&&(this.panel.table[row_start-1][coloumn_start]==Element.point)&&(this.panel.table[row_start-1][coloumn_start+1]==Element.point)){
						update_rotate_state();
						this.panel.table[row_start][coloumn_start]=Element.point;
						this.panel.table[row_start][coloumn_start+2]=Element.point;
						this.panel.table[row_start][coloumn_start+3]=Element.point;
						this.panel.table[row_start-1][coloumn_start+1]=Element.star;
						this.panel.table[row_start+1][coloumn_start+1]=Element.star;
						this.panel.table[row_start-2][coloumn_start+1]=Element.star;
					}
				}
			}
			break;
		case 9:if(this.rotate_state==0){
				if(coloumn_start+1<8){
					if((this.panel.table[row_start][coloumn_start-1]==Element.point)&&(this.panel.table[row_start+2][coloumn_start-1]==Element.point)&&(this.panel.table[row_start][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+1]==Element.point)){
						update_rotate_state();
						this.panel.table[row_start+2][coloumn_start]=Element.point;
						this.panel.table[row_start+1][coloumn_start+1]=Element.star;
					}
				}
			}else if(this.rotate_state==1){
				if(row_start+1<12){
					if((this.panel.table[row_start][coloumn_start-1]==Element.point)&&(this.panel.table[row_start][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+2][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+2][coloumn_start]==Element.point)){
						update_rotate_state();
						this.panel.table[row_start+1][coloumn_start-1]=Element.point;
						this.panel.table[row_start+2][coloumn_start]=Element.star;
					}
				}
			}else if(this.rotate_state==2){
				if(coloumn_start-1>=0){
					if((this.panel.table[row_start][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+2][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start-1]==Element.point)&&(this.panel.table[row_start+2][coloumn_start-1]==Element.point)){
						update_rotate_state();
						this.panel.table[row_start][coloumn_start]=Element.point;
						this.panel.table[row_start+1][coloumn_start-1]=Element.star;
					}
				}
			}else if(this.rotate_state==3){
				if((this.panel.table[row_start-1][coloumn_start]==Element.point)&&(this.panel.table[row_start-1][coloumn_start+1]==Element.point)&&(this.panel.table[row_start+1][coloumn_start]==Element.point)&&(this.panel.table[row_start+1][coloumn_start+2]==Element.point)){
					update_rotate_state();
					this.panel.table[row_start][coloumn_start+2]=Element.point;
					this.panel.table[row_start-1][coloumn_start+1]=Element.star;
				}
			}
			break;
		case 10:break;
	}

	    
		System.out.println("Rotate Once!");	
		return new OpResult(ReturnCode.S001);
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
	public OpResult queryQueue(int time)
	{
		if(time<this.sys_time){
			System.out.println("Time ERROR!");
			return new OpResult(ReturnCode.E008);
		}else{
			if(this.is_active==0){
				Update();
			}
			time_go(time-this.sys_time);
			int i=0;
			
			for(i=0;i<10;i++){
				if(this.queue[i]==66){
					break;
				}
			}
			int length=i;
			int[] list=new int[length];
			for(i=0;i<length;i++){
				list[i]=this.queue[i];
				System.out.print(list[i]);
			}
			System.out.println(" ");
			return new OpResult(new Queue(list));
		}
	}

	/**
	 * 查询积木队列
	 * 
	 * @param time
	 *            时间
	 * @return 查询结果
	 */
	@Override
	public OpResult queryPanel(int time)
	{
		if(time<this.sys_time){
			System.out.println("Time ERROR!");
			return new OpResult(ReturnCode.E008);
		}else{
			if(this.is_active==0){
				Update();
			}
			time_go(time-this.sys_time);
			int i,j;
			FillType[][] blocks=new FillType[12][8];
			for(i=0;i<12;i++){
				for(j=0;j<8;j++){
					if(this.panel.table[i][j]==Element.point){
						blocks[i][j]=FillType.NONE;
					}else if(this.panel.table[i][j]==Element.star){
						blocks[i][j]=FillType.ACTIVE;
					}else{
						blocks[i][j]=FillType.FIXED;
					}
				}
			}
			Panel temp=new Panel(blocks);
			return new OpResult(temp);
		}
	}

	public void time_go(int t){
		int i=0;
		int t_now = t;
		for(i=0;i<t_now;i++){
			moveDown(1);
			this.sys_time++;
		}
	}

}


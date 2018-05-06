package solution;

import java.util.Vector;
import jigsaw.Jigsaw;
import jigsaw.JigsawNode;


/**
 * 在此类中填充算法，完成重拼图游戏（N-数码问题）
 */
public class Solution extends Jigsaw {

	  private Vector<JigsawNode> openList; 
	  // open表 ：用以保存已发现但未访问的节点
	  private Vector<JigsawNode> closeList; 
	  // close表：用以保存已访问的节点

	  // 解路径 ：用以保存从起始状态到达目标状态的移动路径中的每一个状态节点
	  private boolean isCompleted; 
	  // 完成标记：初始为false;当求解成功时，将该标记至为true
 
	  // 已访问节点数： 用以记录所有访问过的节点的数量
	  
	/**
     * 拼图构造函数
     */
    public Solution() {

		
		this.isCompleted = false;
    }

    /**
     * 拼图构造函数
     * @param bNode - 初始状态节点
     * @param eNode - 目标状态节点
     */
    public Solution(JigsawNode bNode, JigsawNode eNode) {
    	
        super(bNode, eNode);

		
		this.isCompleted = false;
        
    }

    
    
	//find next nodes
    private Vector<JigsawNode> findFollowJNodes(JigsawNode jNode) {
		Vector<JigsawNode> followJNodes = new Vector<JigsawNode>();
		JigsawNode tempJNode;
		for(int i=0; i<4; i++){
			tempJNode = new JigsawNode(jNode);
			if(tempJNode.move(i) && !this.closeList.contains(tempJNode) && !this.openList.contains(tempJNode))
				followJNodes.addElement(tempJNode);
		}
		return followJNodes;
	}

	/**排序插入openList：按照节点的代价估值（estimatedValue）将节点插入openList中，估值小的靠前。
	 * @param jNode - 要插入的状态节点
	 */
	private void addNodeOpenList(JigsawNode jNode) {
		estimateValue(jNode);
		for (int i = 0; i < this.openList.size(); i++) {
			if (jNode.getEstimatedValue() < openList.elementAt(i).getEstimatedValue()) {
				openList.insertElementAt(jNode, i);
				return;
			}
		}
		this.openList.addElement(jNode);
	}
    /**
     *（实验一）广度优先搜索算法，求指定5*5拼图（24-数码问题）的最优解
     * 填充此函数，可在Solution类中添加其他函数，属性
     * @param bNode - 初始状态节点
     * @param eNode - 目标状态节点
     * @return 搜索成功时为true,失败为false
     */
    public boolean BFSearch(JigsawNode bNode, JigsawNode eNode) {
    	

    	this.openList = new Vector<JigsawNode>();
		this.closeList = new Vector<JigsawNode>();
        // if finished ,return true
		isCompleted = false;

		int searchedNodesNum = 0;
		// store the follow nodes
		Vector<JigsawNode> followNode = new Vector<JigsawNode>();
		
		beginJNode = bNode;
		endJNode = eNode;
      
		addNodeOpenList(beginJNode);

        
        while (openList.isEmpty() != true) {
            // openList first node = currentJNode
            //      currentJNode == endJNode,finish,isCompleted=true，exit
            currentJNode = openList.elementAt(0);
            if (currentJNode.equals(this.endJNode)){
                isCompleted = true;
               // this.calSolutionPath();
                break;
            }

            // delete the node in open ,and add the node in close(2-2)从openList中删除节点N,并将其放入closeList中，表示以访问节点			
			openList.removeElementAt(0);
			closeList.addElement(this.currentJNode);
			searchedNodesNum++;

           
            // find is not visited node and add to the openlist
			followNode = this.findFollowJNodes(currentJNode);
            while (!followNode.isEmpty()) {
                //this.addNodeOpenList(followNode.elementAt(0));
            	openList.addElement(followNode.get(followNode.size()-1));
            	followNode.remove(followNode.size()-1);
                
            }
        }
    	//return true;
        getPath();
    	System.out.println("Solution Path: "+"\n"+"Solution Path: "+"\n"+getSolutionPath()+"\n"+"Begin state:" + this.getBeginJNode().toString()
    			+"\n"+"End state:"+ this.getEndJNode().toString()+"Total number of searched nodes:" + searchedNodesNum+"\n"+ "Depth of the current node is:" + this.getCurrentJNode().getNodeDepth() );
		return isCompleted;
    }


    /**
     *（Demo+实验二）计算并修改状态节点jNode的代价估计值:f(n)
     * 如 f(n) = s(n). s(n)代表后续节点不正确的数码个数
     * 此函数会改变该节点的estimatedValue属性值
     * 修改此函数，可在Solution类中添加其他函数，属性
     * @param jNode - 要计算代价估计值的节点
     */
    public void estimateValue(JigsawNode jNode) {
        int s = 0; 
        int dimension = JigsawNode.getDimension();
       // System.out.println("enter!");
        for (int index = 1; index < dimension * dimension; index++) {
            if (jNode.getNodesState()[index] + 1 != jNode.getNodesState()[index + 1]) {
                s++;
            }
        }
        
     // the current position get wrong piece.
        int falsePiece = 0;
        for (int index = 1; index < dimension * dimension; index++) {
            if (jNode.getNodesState()[index] != index)
            	{falsePiece++;}
          }
        
        int mahadis = 0;
        int distance = 0;
        
        for(int curIndex = 1; curIndex <= dimension*dimension; curIndex++){
			int realNum = jNode.getNodesState()[curIndex];
			if (realNum != curIndex && realNum != 0) {
				int realX = (realNum - 1) % dimension;
				int realY = (realNum - 1) / dimension;
				int indexX = (curIndex - 1) % dimension;
				int indexY = (curIndex - 1) / dimension;
				distance = Math.abs(realX - indexX) + Math.abs(realY - indexY);
				mahadis += distance;

			}	
		}
      
        int power1 = 200,power2 = 400,power3=1200,power4 = power1;
        int estimate = (int) (s * power1 + mahadis * power2 + distance * power3 + falsePiece * power4);
       
        jNode.setEstimatedValue(estimate);
    }
}

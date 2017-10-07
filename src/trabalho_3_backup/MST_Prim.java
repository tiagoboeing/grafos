package trabalho_3_backup;

public class MST_Prim
{
    private int data[][];
    
    
    private int [][] mstpdata;
    MST_Prim(int data[][])
    {
        this.data=new int [data.length][data.length];
        this.data=data;        
        this.mstpdata =new int [data.length][data.length];
    }

    private void  MST_Prim()
    {
        java.util.LinkedList<Integer> set =new java.util.LinkedList<Integer>();
        java.util.LinkedList<Edge> q =new java.util.LinkedList<Edge>();
        set.add(0);
        int hold=0;
        while(set.size()<data.length)
        {
            for(int i=0;i<data.length;i++)
            {
                if(data[hold][i]!=0)
                {
                    boolean a=true;
                    for(int j=0;j<set.size();j++)
                    {
                        if(set.get(j)==i)
                        {
                           a=false;
                           break;
                        }
                    }
                    if(a)
                    {
                        q.add(new Edge(hold,i,data[hold][i]));
                    }
                }
            }

            for(int i=q.size()-1;i>=0;i--)
            {
                for(int j=0;j<i;j++)
                {
                    if(q.get(j).weight>q.get(j+1).weight)
                    {
                        Edge ehold=new Edge();
                        ehold=q.remove(j);
                        q.add(j+1,ehold);
                    }
                }
            }
            Edge h =new Edge();
            h=q.removeFirst();
            mstpdata[h.u][h.v]=h.weight;
            hold=h.v;
            set.add(h.v);
        }
    }
    public int getcost()
    {
        int answer=0;
        MST_Prim();
        for(int i=0;i<mstpdata.length;i++)
        {
            for(int j=0;j<data[i].length;j++)
            {
                answer+=mstpdata[i][j]; 
            }
        }
        return answer;
    }
    class Edge
    {
        int weight,u,v;
        Edge(int u,int v,int weight)
        {
            this.u=u;
            this.v=v;
            this.weight=weight;
        }
        Edge(){}   
    }
}
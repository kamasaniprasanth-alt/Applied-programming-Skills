class Solution {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
                int[] parents = new int[n];

                        // i             0 1 2 3 4 5
                                // parents      [0,1,2,3,4,5]
                                        // merge edges  [0,0,0,3,3,3]  

                                                // initlize with itself
                                                        for(int i =0; i < n; i++){
                                                                    parents[i] = i;
                                                                            }
                                                                                    
                                                                                            // merge edges
                                                                                                    for(int[] edge : edges) {
                                                                                                                unionParent(edge[0], edge[1], parents);
                                                                                                                        }

                                                                                                                                // find their roots
                                                                                                                                        return findParent(source, parents) == findParent(destination, parents);
                                                                                                                                            }

                                                                                                                                                public int findParent(int x, int[] parents) {
                                                                                                                                                        if(parents[x] != x){
                                                                                                                                                                    parents[x] = findParent(parents[x], parents);
                                                                                                                                                                            }
                                                                                                                                                                                    return parents[x];
                                                                                                                                                                                        }

                                                                                                                                                                                            public void unionParent(int x, int y, int[] parents){
                                                                                                                                                                                                    int px = findParent(x, parents);
                                                                                                                                                                                                            int py = findParent(y, parents);

                                                                                                                                                                                                                    if(px != py) parents[py] = px;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        }

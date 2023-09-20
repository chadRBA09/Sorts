class sort {
    
    public static void Imprime(int V[]){
        for(int i=0;i<V.length;i++){
            System.out.print(V[i]+" ");
        }
        System.out.println();
    }

    public static void Intercalar (int esq, int meio, int dir, int array[])
    {
        int nEsq = (meio+1) - esq; // tamanho esq
        int nDir = dir - meio; // tamanho dir

        int[] arrayEsq = new int [nEsq+1];
        int[] arrayDir = new int [nDir+1];

        arrayEsq[nEsq] = arrayDir[nDir] = -0x7FFFFFFF;

        int iEsq, iDir,i; 
        
        //inicialiando primeiro subarray
        for(iEsq = 0; iEsq < nEsq; iEsq++)
        {
            arrayEsq[iEsq] = array[esq + iEsq];
        }

        //inicialiando segundo subarray
        for(iDir = 0; iDir < nDir; iDir++)
        {
            arrayDir[iDir] = array[(meio+1) + iDir];
        }

        //intercalação propriamente dita
        for (iEsq = iDir = 0, i = esq; i <= dir; i++)
        {
            array[i] = (arrayEsq[iEsq] >= arrayDir[iDir]) ? arrayEsq[iEsq++] : arrayDir[iDir++];
        }
    }
    
    
    
    public static void mergesort (int esq, int dir, int[] array)
    {
        if (esq < dir)
        {
            int meio = (esq + dir)/2;
            mergesort(esq, meio,array);
            mergesort(meio+1, dir,array);
            Intercalar(esq,meio,dir,array);
        }
    }
    
    public static void mergeDecrescente (int[] array)
    {
        mergesort(0,array.length-1,array);

    }
    
    
    
    public static void quicksort (int[] V){
        quicksort(V, 0, V.length-1);
    }

    public static void quicksort (int[] V, int esq, int dir){
        int i = esq, j = dir;
        int pivo = V[(dir+esq)/2];
        while (i <= j) {
            while (V[i] < pivo) i++;
            while (V[j] > pivo) j--;
            if (i <= j) {
                int temp = V[i];
                V[i]=V[j];
                V[j]=temp;
                i++;
                j--;
            }
        }
        if (esq < j)  quicksort(V, esq, j);
        if (i < dir)  quicksort(V, i, dir);
    }

    public static boolean isOrdenado (int[] V){
        for(int i=0;i<V.length-1;i++){
            if(V[i]>V[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void bubble (int[] V){
        while(!isOrdenado(V)){
            for(int i=0;i<V.length-1;i++){
                if(V[i]>V[i+1]){
                    int temp = V[i];
                    V[i]=V[i+1];
                    V[i+1]=temp;
                }
            }
        }
    }

    public static void insertion (int[] V){
        for(int i=0;i<V.length-1;i++){
            if(V[i]>V[i+1]){
                int j=i+1;
                while(j>=1 && V[j-1]>V[j]){
                    int temp = V[j];
                    V[j]=V[j-1];
                    V[j-1]=temp;
                    j--;
                }
            }
        }
    }

    public static void selection (int[] V){ 
        for(int i=0; i<V.length; i++){
            int menor=i;
            for(int j = i+1; j<V.length; j++){
                if(V[j]<V[menor]){
                    menor=j; 
                }
            }
            int temp = V[menor];
            V[menor] = V[i];
            V[i] = temp;
        }
    }
    public static void main(String[] args){
        int arr[] = {5, 9, 1, 3, 8};
        //selection(arr);
        //insertion(arr);
        //bubble(arr);
        //quicksort(arr);
        //mergeDecrescente(arr);
        //mergesort(0,arr.length-1,arr);
        //Imprime(arr);
    }
}
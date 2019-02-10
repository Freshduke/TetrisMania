if( this.panel.table[i+1][j-1] == Element.star)
        {
        return 0;   // rotate 0
        }
        else
        {
        if(this.panel.table[i+2][j] == Element.star && this.panel.table[i][j+2] == Element.star)
        {
        return 2;   // rotate 2   //########################################################################！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
        }
        else if(this.panel.table[i][j+2] == Element.star && this.panel.table[i+2][j+2] == Element.star)
        {
        return 3;   // rotate 3   //########################################################################！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
        }
        else if(this.panel.table[i+2][j] == Element.star && this.panel.table[i+2][j+2] == Element.star)
        {
        return 1;   // rotate 1   //########################################################################！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
        }
        }
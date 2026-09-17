class MinStack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> mS = new Stack<>();
    public MinStack() {
        st = new Stack<>();
        mS = new Stack<>();
    }
    
    public void push(int value) {
        st.push(value);

        if(mS.isEmpty()){
            mS.push(value);
        }else{
            mS.push(Math.min(value,mS.peek()));
        }
    }
    
    public void pop() {
        st.pop();
        mS.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return mS.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
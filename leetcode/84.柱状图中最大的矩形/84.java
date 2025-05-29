class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> st = new ArrayDeque<>();
        int res = 0;
        st.push(-1);
        for(int right = 0; right <= heights.length; right++){
            int h = right < heights.length ? heights[right] : -1;
            while(st.size() > 1 && h <= heights[st.peek()]){
                int cur_height = heights[st.pop()];
                int left = st.peek();
                res = Math.max(res, cur_height * (right - left - 1));
            }
            st.push(right);
        }
        return res;
    }
}
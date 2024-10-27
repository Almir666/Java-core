package Algorithms.LeetCode.Two_pointers;

// Container With Most Water

// Дано целое число height длины n. Проведено n вертикальных линий так, что две конечные точки i-й линии - (i, 0) и (i, height[i]).
// Найдите две прямые, которые вместе с осью x образуют контейнер, содержащий наибольшее количество воды.
// Верните максимальное количество воды, которое может вместить контейнер.
// Обратите внимание, что контейнер нельзя наклонять.

public class Task5 {

    // Один указатель указывает на первую колонну, другой на последнюю
    // Вычисляем текущую площадь, она находится на границе, т.е. два крайних столбика
    // далее берем меньший столбик для сравнения, и двигаем указатели в том случае если они еще не дошли до серидины
    // и при условии что столбик с текущим индексом меньше или равен минимальному столбу, ну а если нет указатели остановятся на мксимальной 
    // площади 
    
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int start = 0, end = height.length - 1;
        while(start < end) {
            maxArea = Math.max(maxArea, (end - start) * Math.min(height[end], height[start]));
            int min = Math.min(height[start], height[end]); 
            while (start < end && height[start] <= min) {
                start++;
            }
            while (start < end && height[end] <= min) {
                end--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}

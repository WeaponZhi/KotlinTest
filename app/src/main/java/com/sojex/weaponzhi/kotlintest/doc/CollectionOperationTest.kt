package com.sojex.weaponzhi.kotlintest.doc

import org.junit.Assert.*

/**
 * 容器、集合操作符测试类，当做 API、操作符文档使用
 * author:张冠之
 * time: 2017/6/22 11:11
 * e-mail: guanzhi.zhang@sojex.cn
 */

class CollectionOperationTest {
    //源数据
    val list = listOf(1, 2, 3, 4, 5, 6)
//==========================================总数操作符=================================================
    /**
     * any
     * 如果至少有一个元素符合给出的判断条件，返回 true
     */
    fun testAny() {
        assertTrue(list.any { it % 2 == 0 })
        assertFalse(list.any { it > 10 })
    }

    /**
     * all
     * 如果全部的元素都符合给出的判断条件，则返回 true
     */
    fun testAll() {
        assertTrue(list.all { it < 10 })
        assertFalse(list.all { it % 2 == 0 })
    }

    /**
     * count
     * 返回符合给出判断条件的元素总数
     */
    fun testCount() {
        assertEquals(3, list.count { it % 2 == 0 })
    }

    /**
     * fold
     * 在一个初始值的基础上行从第一项到最后一项通过一个函数累计所有的元素
     */
    fun testFold() {
        assertEquals(25, list.fold(4) { total, next -> total + next })
    }

    /**
     * flodRight
     * 与 fold 一样，但是顺序是从最后一项到第一项
     */
    fun testFoldRight() {
        assertEquals(25, list.foldRight(4) { total, next -> total + next })
    }

    /**
     * forEach
     * 遍历所有元素，并执行给定的操作
     */
    fun testForEach() {
        list.forEach { println(it) }
    }

    /**
     * forEachIndexed
     * 与 forEach 一样，但是我们同时可以得到元素的 index
     */
    fun testForEachIndexed() {
        list.forEachIndexed { index, value -> println("position $index contains a $value") }
    }

    /**
     * max
     * 返回最大的一项，如果没有则返回 null
     */
    fun testMax() {
        assertEquals(6, list.max())
    }

    /**
     * maxBy
     * 返回最大的一项，如果没有则返回 null
     */
    fun testMaxBy() {
        assertEquals(1, list.maxBy { -it })
    }

    /**
     * min
     * 返回最小的一项，如果没有则返回 null
     */
    fun testMin() {
        assertEquals(1, list.min())
    }

    /**
     * minBy
     * 根据给定的函数返回最小的一项，如果没有则返回 null
     */
    fun testMinBy() {
        assertEquals(6, list.minBy { -it })
    }

    /**
     * none
     * 如果没有任何元素与给定的函数匹配，则返回 true
     */
    fun testNone() {
        assertTrue(list.none { it % 7 == 0 })
    }

    /**
     * reduce
     * 与 fold 一样，但是没有一个初始值。
     */
    fun testReduce() {
        assertEquals(21, list.reduce { total, next -> total + next })
    }

    /**
     * reduceRight
     * 与 reduce 一样，但是顺序是从最后一项到第一项
     */
    fun testReduceRight() {
        assertEquals(21, list.reduceRight { total, next -> total + next })
    }

    /**
     * sumBy
     * 返回所有每一项通过函数转换之后的数据的总和
     */
    fun testSumBy() {
        assertEquals(3, list.sumBy { it % 2 })
    }
//=======================过滤操作符===================================================================
    /**
     * drop
     * 返回包含去掉前 n 个元素的所有元素的列表
     */
    fun testDrop() {
        assertEquals(listOf(5, 6), list.drop(4))
    }

    /**
     * dropWhile
     * 返回根据给定函数从第一项开始去掉指定元素的列表
     */
    fun testDropWhile() {
        assertEquals(listOf(3, 4, 5, 6), list.dropWhile { it < 3 })
    }

    /**
     * dropLastWhile
     * 返回根据给定函数从最后一项开始去掉指定元素的列表
     */
    fun testDropLastWhile() {
        assertEquals(listOf(1, 2, 3, 4), list.dropLastWhile { it > 4 })
    }

    /**
     * filter
     * 过滤所有符合给定函数条件的元素
     */
    fun testFilter() {
        assertEquals(listOf(2, 4, 6), list.filter { it % 2 == 0 })
    }

    /**
     * filterNot
     * 过滤所有不符合给定函数条件的元素
     */
    fun testFilterNot() {
        assertEquals(listOf(1, 3, 5), list.filterNot { it % 2 == 0 })
    }

    /**
     * filterNotNull
     * 过滤所有元素中不是 null 的元素
     */
    fun testFilterNotNull() {
        assertEquals(listOf(1, 2, 3, 4), list.filterNotNull())
    }

    /**
     * slice
     * 过滤一个 list 中指定 index 的元素
     */
    fun testSlice() {
        assertEquals(listOf(2, 4, 5), list.slice(listOf(1, 3, 4)))
    }

    /**
     * take
     * 返回从第一个开始的 n 个元素
     */
    fun testTake() {
        assertEquals(listOf(1, 2), list.take(2))
    }

    /**
     * takeLast
     * 返回从最后一个开始的 n 个元素
     */
    fun testTakeLast() {
        assertEquals(listOf(5, 6), list.takeLast(2))
    }

    /**
     * takeWhile
     * 返回从第一个开始符合给定函数条件的元素
     */
    fun testTakeWhile() {
        assertEquals(listOf(1, 2), list.takeWhile { it < 3 })
    }
    //===================================映射操作符==================================
    /**
     * flatMap
     * 遍历所有元素，为每一个创建一个集合，最后把所有的集合放在一个集合中
     */
    fun testFlatMap() {
        assertEquals(listOf(1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7), list.flatMap { listOf(it, it + 1) })
    }

    /**
     * groupBy
     * 返回一个根据给定函数分组后的 Map
     */
    fun testGroupBy() {
        assertEquals(mapOf("odd" to listOf(1, 3, 5), "even" to listOf(2, 4, 6)), list.groupBy { if (it % 2 == 0) "even" else "odd" })
    }

    /**
     * map
     * 返回一个每一个元素根据给定的函数转换所组成的 List
     */
    fun testMap() {
        assertEquals(listOf(2, 4, 6, 8, 10, 12), list.map { it * 2 })
    }

    /**
     * mapIndexed
     * 返回一个每一个元素根据给定的包含元素 index 的函数转换锁组成的 List
     */
    fun testMapIndexed() {
        assertEquals(listOf(0, 2, 6, 12, 20, 30), list.mapIndexed { index, it -> index * it })
    }

    /**
     * mapNotNull
     * 返回一个每一个元素根据给定的包含元素 index 的函数转换所组成的 List
     */
    fun testMapNotNull() {
        assertEquals(listOf(2, 4, 6, 8), list.map { it * 2 })
    }

    //=============================元素操作符==========================
    /**
     * contains
     * 如果指定元素可以在集合中找到，则返回 true
     */
    fun testContains() {
        assertTrue(list.contains(2))
    }

    /**
     * elementAt
     * 返回给定 index 对应的元素，如果 index 数组越界则会抛出 IndexOutOfBoundsException
     */
    fun testElementAt() {
        assertEquals(2, list.elementAt(1))
    }

    /**
     * elementAtOrElse
     * 返回给定 index 对应的元素，如果 index 数组越界则会根据给定函数返回默认值
     */
    fun testElementAtOrElse() {
        assertEquals(20, list.elementAtOrElse(10, { 2 * it }))
    }

    /**
     * elementAtOrNull
     * 返回给定 index 对应的元素，如果 index 数组越界则会返回 null
     */
    fun testElementAtOrNull() {
        assertNull(list.elementAtOrNull(10))
    }

    /**
     * first
     * 返回符合给定函数条件的第一个元素
     */
    fun testFirst() {
        assertEquals(2, list.first { it % 2 == 0 })
    }

    /**
     * firstOrNull
     * 返回符合给定函数条件的第一个元素，如果没有符合则返回 null
     */
    fun testFirstOrNull() {
        assertNull(list.firstOrNull { it % 7 == 0 })
    }

    /**
     * indexOf
     * 返回指定元素的第一个 index ，如果不存在，返回 -1
     */
    fun testIndexOf() {
        assertEquals(3, list.indexOf(4))
    }

    /**
     * indexOfFirst
     * 返回第一个符合给定函数条件的元素的 index，如果没有符合则返回 -1
     */
    fun testIndexOfFirst() {
        assertEquals(1, list.indexOfFirst { it % 2 == 0 })
    }

    /**
     * indexOfLast
     * 返回最后一个符合给定函数条件的元素 index，如果没有符合则返回 -1
     */
    fun testIndexOfLast() {
        assertEquals(5, list.indexOfLast { it % 2 == 0 })
    }

    /**
     * last
     * 返回符合给定函数条件的最后一个元素
     */
    fun testLast() {
        assertEquals(6, list.last { it % 2 == 0 })
    }

    /**
     * lastOrNull
     * 返回符合给定函数条件的最后一个元素，如果没有符合则返回 null
     */
    fun testLastOrNull() {
        val list = listOf(1, 2, 3, 4, 5, 6)
        assertNull(list.lastOrNull { it % 7 == 0 })
    }

    /**
     * single
     * 返回符合给定函数的单个元素，如果没有符合或者超过一个，则抛出异常
     */
    fun testSingle() {
        assertEquals(5, list.single { it % 5 == 0 })
    }

    /**
     * singleOrNull
     * 返回符合给定函数的单个元素，如果没有符合或者超过一个，则返回 null
     */
    fun testSingleOrNull() {
        assertNull(list.singleOrNull { it % 7 == 0 })
    }
    //===============================生产操作符=========================================
    /**
     * merge
     * 把两个集合合并成一个新的，相同 index 的元素通过给定的函数进行合并成新的元素作为
     * 新的集合的一个元素，返回这个新的集合。新的集合的大小由最小的那个集合大小决定。
     */
    fun testMerge() {
        val list = listOf(1, 2, 3, 4, 5, 6)
        val listRepeated = listOf(2, 2, 3, 4, 5, 5, 6)
//        assertEquals(listOf(3, 4, 6, 8, 10, 11), list.merge(listRepeated) { it1, it2 -> it1 + it2 })
    }

    /**
     * partition
     * 把一个给定的集合分割成两个，第一个集合是由原集合每一项元素匹配给定函数条件返回 true 的元素组成，
     * 第二个集合是由原集合每一项元素匹配给定函数条件返回 false 的元素组成
     */
    fun testPartition() {
        assertEquals(
                Pair(listOf(2, 4, 6), listOf(1, 3, 5)),
                list.partition { it % 2 == 0 }
        )
    }

    /**
     * plus
     * 返回一个包含原集合和给定集合中所有元素的集合，因为函数名字相同，所以我们可以用 “+” 操作符
     */
    fun testPlus() {
        listOf(1, 2, 3, 4, 5, 6, 7, 8)
        list + listOf(7, 8)
    }

    /**
     * zip
     * 返回由 pair 组成的 List，每个 pair 由两个集合中相同 index 的元素组成。这个返回的
     * List 的大小由最小的那个集合决定。
     */
    //Pair 是 Kotlin 提供的用来处理双元对数据的，可以理解成 Map 中的一个键值对。
    fun testZip() {
        assertEquals(
                listOf(Pair(1, 7), Pair(2, 8)),
                list.zip(listOf(7, 8))
        )
    }

    /**
     * unzip
     * 从包含 pair 的 List 中生成包含 List 的 Pair
     */
    fun testUnZip() {
        assertEquals(
                Pair(listOf(5, 6), listOf(7, 8)),
                listOf(Pair(5, 7), Pair(6, 8)).unzip()
        )
    }

    //=================================顺序操作符===========================================
    val unsortedList = listOf(3, 2, 7, 5)

    /**
     * reverse
     * 返回一个与指定 list 相反顺序的 list
     */
    fun testReverse() {
        assertEquals(listOf(5, 7, 2, 3), unsortedList.reversed())
    }

    /**
     * sort
     * 返回一个自然排序后的 list。
     */
    fun testSort() {
        assertEquals(listOf(2, 3, 5, 7), unsortedList.sorted())
    }

    /**
     * sortBy
     * 返回一个根据指定函数排序后的 list
     */
    fun testSortBy() {
        assertEquals(listOf(3, 7, 2, 5), unsortedList.sortedBy { it % 3 })
    }

    /**
     * sortDescending
     * 返回一个降序排序后的 List
     */
    fun testSortDescending() {
        assertEquals(listOf(7, 5, 3, 2), unsortedList.sortedDescending())
    }

    /**
     * sortDescendingBy
     * 返回一个根据指定函数降序排序后的 list
     */
    fun testSortDescendingBy() {
        assertEquals(listOf(2, 5, 7, 3), unsortedList.sortedByDescending { it % 3 })
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var collection = CollectionOperationTest()
            println(collection.unsortedList.sortedBy { it % 3 })
            println(collection.unsortedList)
        }
    }
}


































remark* 表示心得或者坑  值得注意 remark*-数字

remark*-1
    浏览器访问不乱码，但是junit访问怎么都乱码，必须setCharacterEncoding一次
    原因是通过浏览器 我们是经过了web.xml中的过滤器，request和response都被强制编码了一次
    但是junit不经过web.xml,所以默认编码是ISO-9958-1

remark*-2
    springmvc controller在接受json数组的时候 不管是数组或者list接受 如String[] strArr 或 List<String> strList
    一定要用@RequestBody

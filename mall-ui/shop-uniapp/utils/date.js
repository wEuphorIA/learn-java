//时间不足两位在前面补0
export const addZero = (s) => {
	return s < 10 ? ('0' + s) : s;
}
// 格式化当前时间yyyy.mm.dd
export const getNow = (val) => {
  console.log(val)
	let date = new Date(val);
	let y = date.getFullYear();
	let m = date.getMonth() + 1;
	let d = date.getDate();
	return addZero(y) + "." + addZero(m) + "." + addZero(d);
}
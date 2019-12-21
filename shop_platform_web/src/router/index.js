import Vue from 'vue'
import Router from 'vue-router'
import Goods_info_index from '@/components/Goods_info_index'
import Register from '@/components/Register'
import Login from '@/components/Login'
import GoodDetails from '@/components/GoodsDetails'
import Order from '@/components/Order'
import ShoppingCar from '@/components/ShoppingCar'
import Echarts_OrderNumber from '@/components/Echarts_OrderNumber'

Vue.use(Router)

export default new Router({
	routes: [{
			path: '/',
			name: 'goods_info_index',
			component: Goods_info_index
		},
		{
			path: '/register',
			name: 'register',
			component: Register
		},
		{
			path: '/login',
			name: 'login',
			component: Login
		},
		{
			path: '/goods_details',
			name: 'goods_details',
			component: GoodDetails
		},
		{
			path: '/order',
			name: 'order',
			component: Order
		},
		{
			path: '/shoppingCar',
			name: 'shoppingCar',
			component: ShoppingCar
		},
		{
			path: '/echarts_OrderNumber',
			name: 'echarts_OrderNumber',
			component: Echarts_OrderNumber
		}
	]
})
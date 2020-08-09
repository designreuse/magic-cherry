//package com.community.controller.cms;
//
//
//import org.broadleafcommerce.core.catalog.domain.Product;
//import org.broadleafcommerce.core.inventory.service.InventoryUnavailableException;
//import org.broadleafcommerce.core.order.service.call.AddToCartItem;
//import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
//import org.broadleafcommerce.core.order.service.exception.AddToCartException;
//import org.broadleafcommerce.core.order.service.exception.IllegalCartOperationException;
//import org.broadleafcommerce.core.order.service.exception.ProductOptionValidationException;
//import org.broadleafcommerce.core.order.service.exception.RemoveFromCartException;
//import org.broadleafcommerce.core.order.service.exception.RequiredAttributeNotProvidedException;
//import org.broadleafcommerce.core.order.service.exception.UpdateCartException;
//import org.broadleafcommerce.core.pricing.service.exception.PricingException;
//import org.broadleafcommerce.core.web.controller.cart.BroadleafCartController;
//import org.broadleafcommerce.core.web.order.CartState;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Created by peng.yang on ${Date}
// */
//@Controller
//@RequestMapping("/")
//public class CmsController {
//
//    @RequestMapping("")
//    public String homepage(HttpServletRequest request, HttpServletResponse response, Model model) throws PricingException {
//
//        return "layout/homepage";
//    }
//
//}

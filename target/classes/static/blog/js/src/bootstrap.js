/* global CLUAS: true */

$(document).ready(function () {

  $(document).trigger('bootstrap:before');

  CLUAS.utils.isMobile() && window.FastClick.attach(document.body);

  CLUAS.utils.lazyLoadPostsImages();

  CLUAS.utils.registerESCKeyEvent();

  CLUAS.utils.registerBackToTop();

  $('.site-nav-toggle button').on('click', function () {
    var $siteNav = $('.site-nav');
    var ON_CLASS_NAME = 'site-nav-on';
    var isSiteNavOn = $siteNav.hasClass(ON_CLASS_NAME);
    var animateAction = isSiteNavOn ? 'slideUp' : 'slideDown';
    var animateCallback = isSiteNavOn ? 'removeClass' : 'addClass';

    $siteNav.stop()[animateAction]('fast', function () {
      $siteNav[animateCallback](ON_CLASS_NAME);
    });
  });


  CONFIG.fancybox && CLUAS.utils.wrapImageWithFancyBox();
  CLUAS.utils.embeddedVideoTransformer();
  CLUAS.utils.addActiveClassToMenuItem();


  // Define Motion Sequence.
  CLUAS.motion.integrator
    .add(CLUAS.motion.middleWares.logo)
    .add(CLUAS.motion.middleWares.menu)
    .add(CLUAS.motion.middleWares.postList)
    .add(CLUAS.motion.middleWares.sidebar);

  $(document).trigger('motion:before');

  // Bootstrap Motion.
  CONFIG.motion && CLUAS.motion.integrator.bootstrap();

  $(document).trigger('bootstrap:after');
});
